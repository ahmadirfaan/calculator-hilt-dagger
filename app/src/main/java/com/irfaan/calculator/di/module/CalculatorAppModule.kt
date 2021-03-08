package com.irfaan.calculator.di.module

import com.irfaan.calculator.data.api.CalculatorApi
import com.irfaan.calculator.utils.AppsConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class CalculatorAppModule {

    @Singleton
    @Provides
    fun provideMoshiConverter() : MoshiConverterFactory = MoshiConverterFactory.create()

    @Singleton
    @Provides
    fun provideRetrofitInstance(moshi : MoshiConverterFactory) : Retrofit {
        return Retrofit.Builder().baseUrl(AppsConstant.BASE_URL)
            .addConverterFactory(moshi)
            .client(AppsConstant.client)
            .build()
    }
}