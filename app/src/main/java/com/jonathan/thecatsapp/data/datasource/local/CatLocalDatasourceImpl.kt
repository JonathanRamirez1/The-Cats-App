package com.jonathan.thecatsapp.data.datasource.local

import com.jonathan.thecatsapp.data.datasource.local.dao.CatDao
import com.jonathan.thecatsapp.data.datasource.local.entity.CatEntity
import javax.inject.Inject

class CatLocalDatasourceImpl @Inject constructor(private val catDao: CatDao): CatLocalDatasource {

    override suspend fun getAllCats(): CatEntity {
        return catDao.getAllCats()
    }

    override suspend fun insertAllCats(catEntity: CatEntity) {
        catDao.insertAllCats(catEntity)
    }
}
