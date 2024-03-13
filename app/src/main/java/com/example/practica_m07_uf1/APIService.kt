package com.example.practica_m07_uf1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("transactions")
    fun getTransactions(): Call<List<Transaction>>
}

