package com.jonathan.thecatsapp.di

import com.jonathan.thecatsapp.data.datasource.local.CatLocalDatasource
import com.jonathan.thecatsapp.data.datasource.local.CatLocalDatasourceImpl
import com.jonathan.thecatsapp.data.datasource.remote.network.CatRemoteDataSource
import com.jonathan.thecatsapp.data.datasource.remote.network.CatRemoteDataSourceImpl
import com.jonathan.thecatsapp.data.repository.CatRepository
import com.jonathan.thecatsapp.data.repository.CatRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CatModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(catRemoteDataSourceImpl: CatRemoteDataSourceImpl): CatRemoteDataSource = catRemoteDataSourceImpl

    @Singleton
    @Provides
    fun provideLocalDataSource(catLocalDataSourceImpl: CatLocalDatasourceImpl): CatLocalDatasource = catLocalDataSourceImpl

    @Singleton
    @Provides
    fun provideRepository(catRepositoryImpl: CatRepositoryImpl): CatRepository = catRepositoryImpl
}