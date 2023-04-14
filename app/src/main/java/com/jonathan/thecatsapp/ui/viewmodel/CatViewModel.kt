package com.jonathan.thecatsapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonathan.thecatsapp.domain.CatUseCase
import com.jonathan.thecatsapp.domain.model.Cats
import com.jonathan.thecatsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(private val catUseCase: CatUseCase) : ViewModel() {

    private val _cats = MutableLiveData<Resource<Cats>>()
    val cats: LiveData<Resource<Cats>> = _cats

    fun onCats() {
        viewModelScope.launch {
            _cats.postValue(Resource.loading())
            val cats = catUseCase.getAllCats()
            try {
                _cats.postValue(Resource.success(cats))
            } catch (e: Exception) {
                _cats.postValue(Resource.error(e.message ?: "Ocurrio un error"))
            }
        }
    }
}