package com.example.a20240925_priti_nycchool.repository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitInstanceService {
    private const val  BASE_URL="https://data.cityofnewyork.us"

    @Singleton
    private  val retrofit:Retrofit by lazy {
        Retrofit.
        Builder().
        baseUrl(BASE_URL).
        addConverterFactory(GsonConverterFactory.create()).
        build()
    }

    val schoolService:SchoolService by lazy {
        retrofit.create(SchoolService::class.java)
    }
}