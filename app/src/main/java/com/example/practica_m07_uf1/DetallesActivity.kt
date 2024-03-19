package com.example.practica_m07_uf1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import java.io.Serializable

class DetallesActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "CutPasteId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)

        val transaction: Transaction? = intent.getSerializableExtra("TRANSACTION") as? Transaction

        val displayName = findViewById<TextView>(R.id.textView)
        val displayAmount = findViewById<TextView>(R.id.textView2)

        val displayDate = findViewById<TextView>(R.id.textViewDateDisplay)

        val displayType = findViewById<TextView>(R.id.textViewTypeDisplay)

        if (transaction != null) {
            displayName.text = transaction.name
            displayAmount.text = "${transaction.amount}€"
            displayType.text = transaction.type
            displayDate.text = transaction.date
            // Set other details as needed
        }

    }
}