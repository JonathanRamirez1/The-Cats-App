package com.jonathan.thecatsapp.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import coil.request.ImageRequest
import com.jonathan.thecatsapp.R
import com.jonathan.thecatsapp.databinding.ItemCatsBinding
import com.jonathan.thecatsapp.domain.model.Cats
import com.jonathan.thecatsapp.utils.Constants.BASE_IMAGE_URL

class CatAdapter(private val itemCat: ArrayList<Cats>?): RecyclerView.Adapter<CatAdapter.CatViewHolder>()  {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatAdapter.CatViewHolder {
        context = parent.context
        return CatViewHolder(
            ItemCatsBinding.inflate(
                LayoutInflater.from(context)
            )
        )
    }

    override fun onBindViewHolder(holder: CatAdapter.CatViewHolder, position: Int) {
        holder.bind(itemCat!![position], context)
    }

    override fun getItemCount(): Int = itemCat!!.size

    fun submitList(itemList: ArrayList<Cats>?) {
        this.itemCat?.clear()
        if (itemList != null) {
            this.itemCat!!.addAll(itemList)
        }
        notifyItemInserted(itemCat?.size?.minus(1) ?: 0)
    }

    inner class CatViewHolder(private val binding: ItemCatsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(cat: Cats, context: Context) {
            binding.apply {
                val imageRequest = ImageRequest.Builder(context)
                    .data("$BASE_IMAGE_URL${cat.imageUrl}${".jpg"}")
                    .crossfade(true)
                    .size(1280, 720)
                    .target(
                        onStart = {
                            imageViewCats.setImageResource(R.drawable.ic_access_time)
                        },
                        onSuccess = { avatar ->
                            imageViewCats.scaleType = ImageView.ScaleType.CENTER_CROP
                            imageViewCats.setImageDrawable(avatar)
                        },
                        onError = {
                            binding.imageViewCats.setImageResource(R.drawable.ic_load_error)
                        }
                    )
                    .build()
                context.imageLoader.enqueue(imageRequest)
                textViewName.text = cat.name
                textViewOrigin.text = cat.origin
                textViewIntelligence.text = cat.intelligence.toString()
            }
        }
    }
}