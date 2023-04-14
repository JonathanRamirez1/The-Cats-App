package com.jonathan.thecatsapp.data.repository

import com.jonathan.thecatsapp.data.datasource.local.CatLocalDatasource
import com.jonathan.thecatsapp.data.datasource.local.entity.toCats
import com.jonathan.thecatsapp.data.datasource.remote.model.CatModel
import com.jonathan.thecatsapp.data.datasource.remote.model.toCat
import com.jonathan.thecatsapp.data.datasource.remote.network.CatRemoteDataSource
import com.jonathan.thecatsapp.data.exception.NoInternetException
import com.jonathan.thecatsapp.domain.model.Cats
import com.jonathan.thecatsapp.domain.model.toCatEntity
import com.jonathan.thecatsapp.utils.InternetCheck
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(
    private val remoteDataSource: CatRemoteDataSource,
    private val localDatasource: CatLocalDatasource
) : CatRepository {

    override suspend fun getAllCatsFromRemote(): Cats {
        if (!InternetCheck.isNetworkAvailable()) {
            throw NoInternetException("No hay conexión a internet disponible")
        }
        val response: CatModel = remoteDataSource.getCats()
        return response.toCat()
    }

    override suspend fun getAllCatsFromLocal(): Cats {
        return localDatasource.getAllCats().toCats()
    }

    override suspend fun insertAllCats(cats: Cats) {
        localDatasource.insertAllCats(cats.toCatEntity())
    }
}
