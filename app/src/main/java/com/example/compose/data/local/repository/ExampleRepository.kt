package com.example.compose.data.local.repository

import com.example.compose.data.local.dao.ExampleDao
import com.example.compose.domain.model.Example
import javax.inject.Inject

class ExampleRepository @Inject constructor(
    private val exampleDao: ExampleDao
) {
    suspend fun insert(example: Example) {
        exampleDao.insert(example)
    }

    suspend fun findAll() : List<Example> {
       return exampleDao.findAll()
    }
}