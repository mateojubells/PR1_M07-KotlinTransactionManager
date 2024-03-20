package com.example.practica_m07_uf1

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Transaction (
    var id: Int,
    @SerializedName("name") var name: String,
                       @SerializedName("amount") var amount: Int,
                       @SerializedName("date") var date: String,
                       @SerializedName("type") var type: String) : Serializable

