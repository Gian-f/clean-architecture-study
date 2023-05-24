package com.example.compose.domain.di

import com.example.compose.domain.impl.CreateExampleUseCaseImpl
import com.example.compose.domain.impl.FindExampleUseCaseImpl
import com.example.compose.domain.usecase.CreateExampleUseCase
import com.example.compose.domain.usecase.FindExampleUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {

    @Binds
    fun bindCreateExampleUseCase(useCase: CreateExampleUseCaseImpl): CreateExampleUseCase

    @Binds
    fun bindFindExampleUseCase(useCase: FindExampleUseCaseImpl): FindExampleUseCase

}