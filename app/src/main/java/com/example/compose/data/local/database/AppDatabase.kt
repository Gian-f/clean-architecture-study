package com.example.compose.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.compose.data.local.dao.ExampleDao
import com.example.compose.domain.model.Example
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Example::class], version = 1, exportSchema = false)

abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun exampleDao(): ExampleDao

    companion object {

        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getDatabase(scope: CoroutineScope, context: Context): AppRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDatabase::class.java,
                    "database"
                )
                    .addCallback(ExampleDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    private class ExampleDatabaseCallback(
        private val scope: CoroutineScope
    ) : Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.exampleDao())
                }
            }
        }

        fun populateDatabase(exampleDao: ExampleDao) {
            //wordDao.deleteAllWords()
//            var word = Word("Gian")
//            wordDao.insert(word)
//            word = Word("John")
//            wordDao.insert(word)
//            word = Word("João")
//            wordDao.insert(word)
        }
    }
}
