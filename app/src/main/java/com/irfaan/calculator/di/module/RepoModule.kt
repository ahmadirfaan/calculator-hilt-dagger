package com.irfaan.calculator.di.module

import com.irfaan.calculator.data.repository.CalculatorRepository
import com.irfaan.calculator.data.repository.CalculatorRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {

    @Binds
    @Named("CalculatorRepo")
    abstract fun bindsRepositoryApi(calculatorRepositoryImpl: CalculatorRepositoryImpl) : CalculatorRepository
}