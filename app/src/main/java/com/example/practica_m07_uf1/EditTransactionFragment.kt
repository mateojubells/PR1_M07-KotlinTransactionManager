package com.example.practica_m07_uf1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.database_api.Transactiondb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.Serializable

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"


/**
 * A simple [Fragment] subclass.
 * Use the [EditTransactionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditTransactionFragment : Fragment() {

    private lateinit var db: AppDatabase

    private var transaction: Transaction? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            transaction = it.getSerializable(ARG_PARAM1) as Transaction?
        }
        db = AppDatabase.getInstance(requireContext())!!

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_transaction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = view.findViewById<EditText>(R.id.editTextText)
        val amount = view.findViewById<EditText>(R.id.editTextNumber)
        val date = view.findViewById<EditText>(R.id.editTextText2)
        val type = view.findViewById<EditText>(R.id.editTextText3)

        val button = view.findViewById<Button>(R.id.button)

        if (transaction != null) {
            name.setText(transaction!!.name)
            amount.setText(transaction!!.amount.toString())
            date.setText(transaction!!.date)
            type.setText(transaction!!.type)

        }
        button.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                val amountVal: Int = amount.text.toString().toInt()
                val newTransaction: Transactiondb = Transactiondb(transaction?.id, name.text.toString(), amountVal, date.text.toString() ,type.text.toString())

                db.TransactionDAO().updateTransaction(newTransaction)
            }

            Toast.makeText(context, "Transacción editada", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EditTransactionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Transaction?) =
            EditTransactionFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }
    }
}