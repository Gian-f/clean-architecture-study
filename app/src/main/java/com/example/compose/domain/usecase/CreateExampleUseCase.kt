package com.example.compose.domain.usecase

import com.example.compose.domain.model.Example

interface CreateExampleUseCase {

    suspend operator fun invoke(shortDescription: String,longDescription: String): Example

}