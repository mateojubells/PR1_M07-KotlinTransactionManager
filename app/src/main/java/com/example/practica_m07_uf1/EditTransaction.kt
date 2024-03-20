package com.example.practica_m07_uf1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class EditTransaction : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_transaction)

        val transaction: Transaction? = intent.getSerializableExtra("TRANSACTION") as? Transaction

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView3, EditTransactionFragment.newInstance(transaction))
            .commit()
    }
}