package com.example.practica_m07_uf1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Transactiondb (
    @PrimaryKey(autoGenerate = true) var uId: Int?,
    @ColumnInfo(name = "name") var name: String?,
    @ColumnInfo(name = "amount") var amount: Int,
    @ColumnInfo(name = "date") var date: String?,
    @ColumnInfo(name = "type") var type: String?,
)
