package com.jonathan.thecatsapp.data.repository

import com.jonathan.thecatsapp.domain.Cats

interface CatRepository {

    suspend fun getAllCatsFromRemote(): Cats
    suspend fun getAllCatsFromLocal(): Cats
    suspend fun insertAllCats(cats: Cats)
}