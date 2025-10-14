package com.app.movil_examen.di

import com.app.movil_examen.data.local.preferences.CountryPreferences
import com.app.movil_examen.data.remote.api.CountryApiService
import com.app.movil_examen.data.repository.CountryRepositoryImpl
import com.app.movil_examen.domain.repository.CountryRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// di/AppModule.kt
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit
            .Builder()
            .baseUrl("https://restcountries.com/v3.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideCountryApiService(retrofit: Retrofit): CountryApiService = retrofit.create(CountryApiService::class.java)

    @Provides
    @Singleton
    fun provideCountryRepository(api: CountryApiService,  references: CountryPreferences): CountryRepository =
        CountryRepositoryImpl(api, references)
}