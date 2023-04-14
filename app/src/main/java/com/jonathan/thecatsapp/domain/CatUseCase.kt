package com.jonathan.thecatsapp.domain

import com.jonathan.thecatsapp.data.repository.CatRepository
import com.jonathan.thecatsapp.di.IoDispatcher
import com.jonathan.thecatsapp.domain.model.Cats
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CatUseCase @Inject constructor(
    private val catRepository: CatRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun getAllCats(): Cats = withContext(ioDispatcher) {
        val catsLocal = catRepository.getAllCatsFromLocal()
        if (catsLocal == null) {
            val catsRemote = catRepository.getAllCatsFromRemote()
            catRepository.insertAllCats(catsRemote)
            catRepository.getAllCatsFromLocal()
        } else {
            catsLocal
        }
    }
}