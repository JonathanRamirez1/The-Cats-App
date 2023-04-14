package com.jonathan.thecatsapp.data.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jonathan.thecatsapp.data.datasource.local.dao.CatDao
import com.jonathan.thecatsapp.data.datasource.local.entity.CatEntity

@Database(entities = [CatEntity::class], version = 1)
abstract class CatDatabase : RoomDatabase() {

    abstract fun recipeDao(): CatDao
}