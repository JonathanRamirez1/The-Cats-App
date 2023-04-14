package com.jonathan.thecatsapp.di

import android.content.Context
import androidx.room.Room
import com.jonathan.thecatsapp.data.datasource.local.database.CatDatabase
import com.jonathan.thecatsapp.utils.Constants.CATS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, CatDatabase::class.java, CATS_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideItemsDatabase(catDatabase: CatDatabase) = catDatabase.recipeDao()
}