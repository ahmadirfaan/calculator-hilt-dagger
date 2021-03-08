package com.irfaan.calculator.di.module

import com.irfaan.calculator.data.api.CalculatorApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CalculatorApiModule {
    @Singleton
    @Provides
    fun provideCalculatorApi(retrofit : Retrofit) = retrofit.create(CalculatorApi::class.java)
}