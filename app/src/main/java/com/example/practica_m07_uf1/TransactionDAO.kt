package com.example.database_api

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TransactionDAO {
    @Insert
    fun insert(transaction: Transactiondb)

    @Query("SELECT * FROM `Transactiondb` WHERE name LIKE '%' || :name || '%'")
    fun loadAllTransactions(name: String): List<Transactiondb>

    @Query("SELECT * FROM `Transactiondb`")
    fun loadAll(): List<Transactiondb>

    @Delete
    fun deleteTransactions(transaction: Transactiondb)

    @Update
    fun updateTransaction(transaction: Transactiondb)
}
