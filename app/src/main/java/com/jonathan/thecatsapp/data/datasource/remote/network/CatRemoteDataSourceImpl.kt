package com.jonathan.thecatsapp.data.datasource.remote.network

import com.jonathan.thecatsapp.data.datasource.remote.model.CatModel
import com.jonathan.thecatsapp.utils.Constants.API_KEY
import javax.inject.Inject

class CatRemoteDataSourceImpl @Inject constructor(private val catApi: CatApi): CatRemoteDataSource {

    override suspend fun getCats(): CatModel {
       return catApi.getRecipes(API_KEY).let { it.body()!! }
    }
}