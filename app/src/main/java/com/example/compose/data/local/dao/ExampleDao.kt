package com.example.compose.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.compose.domain.model.Example

@Dao
interface ExampleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(example: Example)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(example: Example)

    @Delete
    suspend fun delete(example: Example)

    @Query("DELETE FROM example")
    suspend fun deleteAll()

    @Query("SELECT * FROM example")
    suspend fun findAll(): List<Example>
}