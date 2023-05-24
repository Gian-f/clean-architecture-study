package com.example.compose.domain.impl

import com.example.compose.data.local.repository.ExampleRepository
import com.example.compose.domain.model.Example
import com.example.compose.domain.usecase.CreateExampleUseCase
import java.util.UUID
import javax.inject.Inject

class CreateExampleUseCaseImpl @Inject constructor(
    private val repository: ExampleRepository
): CreateExampleUseCase {

    override suspend fun invoke(shortDescription: String, longDescription: String): Example {
        val example = Example(UUID.randomUUID().toString(), shortDescription, longDescription)
        repository.insert(example)
        return example
    }
}