package com.example.practica_m07_uf1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase // lateinit sirve para que no falle

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        GlobalScope.launch {
            db = AppDatabase.getInstance(applicationContext)!!// obtenemos instancia de la bbdd
            val Transactions = getRetrofit()

            db.TransactionDAO().insert(Transactiondb( "asdas", 12 , "asd", ""));

            MainScope().launch {
                val adapter = Adapter(Transactions)
                recyclerView.adapter = adapter
            }

            Transactions.forEach {
                Log.i("-->", it.toString())
            }
        }
    }

    private  fun getRetrofit(): List<Transaction> {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/mateojubells/transaction/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(APIService::class.java)
        val response = service.getTransactions().execute()

        return response.body() ?: emptyList()
    }
}
