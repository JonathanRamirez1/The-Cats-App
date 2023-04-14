package com.jonathan.thecatsapp.data.datasource.remote.network

import com.jonathan.thecatsapp.data.datasource.remote.model.CatModel

interface CatRemoteDataSource {

    suspend fun getCats(): CatModel
}