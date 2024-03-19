package com.example.practica_m07_uf1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.database_api.TransactionDAO
import com.example.database_api.Transactiondb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddTransactionFragment : Fragment() {
    private lateinit var db: AppDatabase

    private lateinit var editTextNombre: EditText
    private lateinit var editTextAmount: EditText
    private lateinit var editTextDate: EditText
    private lateinit var editTextType: EditText
    private lateinit var btnMostrar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_transaction, container, false)

        editTextNombre = view.findViewById(R.id.editTextText)
        editTextAmount = view.findViewById(R.id.editTextNumber)
        editTextDate = view.findViewById(R.id.editTextText2)
        editTextType = view.findViewById(R.id.editTextText3)
        btnMostrar = view.findViewById(R.id.button)

        db = AppDatabase.getInstance(requireContext())!!

        btnMostrar.setOnClickListener {
            mostrarDatos()
        }
        return view
    }



    private fun mostrarDatos() {
        val nombre = editTextNombre.text.toString()
        val amount = editTextAmount.text.toString().toIntOrNull() ?: 0
        val date = editTextDate.text.toString()
        val type = editTextType.text.toString()

        val transaction = Transactiondb(null, nombre, amount, date, type)

        GlobalScope.launch(Dispatchers.IO) {
            db.TransactionDAO().insert(transaction)
        }
        Toast.makeText(context, "Transacción agregada", Toast.LENGTH_SHORT).show()
        requireActivity().onBackPressed()
        MainActivity().reload();


    }
}