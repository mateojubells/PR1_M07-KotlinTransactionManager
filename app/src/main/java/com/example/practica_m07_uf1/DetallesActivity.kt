package com.example.practica_m07_uf1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import java.io.Serializable

class DetallesActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "CutPasteId", "SetTextI18n", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)

        val transaction: Transaction? = intent.getSerializableExtra("TRANSACTION") as? Transaction

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainerView, DetallesFragment.newInstance(transaction))
                .commit()

        val back = findViewById<ImageButton>(R.id.imageButton)

        back.setOnClickListener {
            finish()
        }

    }

}