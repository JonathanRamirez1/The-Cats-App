package com.jonathan.thecatsapp.ui.view.fragment

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jonathan.thecatsapp.databinding.FragmentCatBinding
import com.jonathan.thecatsapp.domain.model.Cats
import com.jonathan.thecatsapp.ui.view.adapter.CatAdapter
import com.jonathan.thecatsapp.ui.viewmodel.CatViewModel
import com.jonathan.thecatsapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CatFragment : Fragment() {

    private lateinit var binding: FragmentCatBinding
    private lateinit var catAdapter: CatAdapter

    private val catViewModel: CatViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecipesAdapter()
        catViewModel.onCats()
        setObservers()
    }

    private fun setRecipesAdapter() {
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            binding.recyclerViewCats.layoutManager = GridLayoutManager(
                requireContext(), 2,
                GridLayoutManager.VERTICAL, false
            )
        } else {
            binding.recyclerViewCats.layoutManager = GridLayoutManager(
                requireContext(), 5,
                GridLayoutManager.VERTICAL, false
            )
        }
        catAdapter = CatAdapter(arrayListOf())
        binding.recyclerViewCats.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerViewCats.context,
                (binding.recyclerViewCats.layoutManager as LinearLayoutManager).orientation
            )
        )

        binding.recyclerViewCats.adapter = catAdapter
        binding.recyclerViewCats.setHasFixedSize(true)
        binding.recyclerViewCats.itemAnimator = null
    }

    private fun setObservers() {
        catViewModel.cats.observe(viewLifecycleOwner) { catResponse ->
            when (catResponse.status) {
                Resource.Status.SUCCESS -> {
                    lifecycleScope.launch {
                        if (catResponse.data != null) renderList(catResponse.data)
                        binding.recyclerViewCats.visibility = View.VISIBLE
                    }
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(requireContext(), catResponse.message, Toast.LENGTH_SHORT)
                        .show()
                }
                Resource.Status.LOADING -> {
                    binding.recyclerViewCats.visibility = View.GONE
                }
            }
        }
    }

    private fun renderList(data: Cats?) {
        val list = ArrayList<Cats>()
        if (data != null) {
            list.add(data)
        }
        catAdapter.submitList(list)
    }
}