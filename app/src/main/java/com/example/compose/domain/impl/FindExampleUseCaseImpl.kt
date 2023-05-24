package com.example.compose.domain.impl

import com.example.compose.data.local.repository.ExampleRepository
import com.example.compose.domain.model.Example
import com.example.compose.domain.usecase.FindExampleUseCase
import javax.inject.Inject

class FindExampleUseCaseImpl @Inject constructor(
    private val repository: ExampleRepository
): FindExampleUseCase {

    override suspend fun invoke(): List<Example> {
        return repository.findAll()
    }

}