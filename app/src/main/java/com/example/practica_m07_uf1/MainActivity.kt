package com.example.practica_m07_uf1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.database_api.Adapter
import com.example.database_api.Transactiondb
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editTextSearch: EditText = findViewById(R.id.editTextSearch)
        val buttonSearch: Button = findViewById(R.id.buttonSearch)

        buttonSearch.setOnClickListener {
            val searchText = editTextSearch.text.toString()
            if (searchText.isNotEmpty()) {
                searchTransactionsByName(searchText)
                Log.i("","Se ha pulsado la busqueda")
            }else{
                GlobalScope.launch {
                    db = AppDatabase.getInstance(applicationContext)!!

                    val transactions = db.TransactionDAO().loadAll()

                    withContext(Dispatchers.Main) {
                        adapter = Adapter(convertToTransactions(transactions))
                        recyclerView.adapter = adapter
                    }
                }
            }
        }
        val myButton: FloatingActionButton = findViewById(R.id.fabAddTransaction)


        myButton.setOnClickListener {
            val fragment = AddTransactionFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit()
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        GlobalScope.launch {
            db = AppDatabase.getInstance(applicationContext)!!

            val transactions = db.TransactionDAO().loadAll()

            withContext(Dispatchers.Main) {
                adapter = Adapter(convertToTransactions(transactions))
                recyclerView.adapter = adapter
            }
        }
    }

    private fun searchTransactionsByName(name: String) {
        GlobalScope.launch {

            val transactions = db.TransactionDAO().loadAllTransactions(name)

            withContext(Dispatchers.Main) {
                adapter.setData(convertToTransactions(transactions))
            }
        }
    }

    private fun convertToTransactions(transactiondbs: List<Transactiondb>): List<Transaction> {
        val transactions = mutableListOf<Transaction>()
        transactiondbs.forEach { transactiondb ->
            val transaction = Transaction(
                name = transactiondb.name ?: "",
                amount = transactiondb.amount,
                date = transactiondb.date ?: "",
                type = transactiondb.type ?: ""
            )
            transactions.add(transaction)
        }
        return transactions
    }
}