package com.jonathan.thecatsapp.data.datasource.local

import com.jonathan.thecatsapp.data.datasource.local.entity.CatEntity

interface CatLocalDatasource {

    suspend fun getAllCats(): CatEntity
    suspend fun insertAllCats(catEntity: CatEntity)
}