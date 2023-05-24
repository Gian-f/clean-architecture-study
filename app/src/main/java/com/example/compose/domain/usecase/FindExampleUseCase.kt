package com.example.compose.domain.usecase

import com.example.compose.domain.model.Example

interface FindExampleUseCase {
    suspend operator fun invoke(): List<Example>
}