package com.jonathan.thecatsapp.data.datasource.remote.network

import com.jonathan.thecatsapp.data.datasource.remote.model.CatModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {

    @GET("/breeds")
    suspend fun getRecipes(@Query("apiKey") apiKey: String): Response<CatModel>
}