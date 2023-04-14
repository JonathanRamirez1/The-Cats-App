package com.jonathan.thecatsapp.data.datasource.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jonathan.thecatsapp.data.datasource.local.entity.CatEntity

interface CatDao {

    @Query("SELECT * FROM cats_table ORDER BY id ASC")
    suspend fun getAllCats(): CatEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCats(recipes: CatEntity)
}