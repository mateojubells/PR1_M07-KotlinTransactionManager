package com.example.practica_m07_uf1

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TransactionDAO {
    @Insert
    fun insert(transaction: Transactiondb)

    @Query("SELECT * FROM `Transactiondb` WHERE name = :name")
    fun loadAllTransactions(name: String): List<Transactiondb>

    @Query("SELECT * FROM `Transactiondb`")
    fun loadAll(): List<Transactiondb>

    @Delete
    fun deleteTransactions(transaction: Transactiondb)
}