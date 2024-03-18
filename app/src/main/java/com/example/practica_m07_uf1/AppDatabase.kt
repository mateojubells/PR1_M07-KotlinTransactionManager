package com.example.practica_m07_uf1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.database_api.TransactionDAO
import com.example.database_api.Transactiondb

@Database(
    entities = [Transactiondb::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun TransactionDAO(): TransactionDAO
    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "transaction.db").build()
                } }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}