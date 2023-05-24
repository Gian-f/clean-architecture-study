package com.example.compose.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "example")
data class Example(
    @PrimaryKey
    @ColumnInfo("uuid")
    val uuid: String,
    @ColumnInfo("short_description")
    val shortDescription: String? = null,
    @ColumnInfo("long_description")
    val longDescription: String? = null
)
