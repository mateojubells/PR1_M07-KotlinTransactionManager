package com.example.database_api

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.practica_m07_uf1.DetallesActivity
import com.example.practica_m07_uf1.EditTransaction
import com.example.practica_m07_uf1.R
import com.example.practica_m07_uf1.Transaction


class Adapter(private var itemList: List<Transaction>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.transactions, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val transaction = itemList[position]
        holder.bind(transaction,itemList)
    }
    override fun getItemCount(): Int {
        return itemList.size
    }
    fun setData(newTransactions: List<Transaction>) {
        itemList = newTransactions
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(transaction: Transaction, itemList: List<Transaction>){
            val item: ConstraintLayout = itemView.findViewById(R.id.item)
            val name: TextView = itemView.findViewById(R.id.nameTextView)
            val amount: TextView = itemView.findViewById(R.id.amountTextView)
            val edit: ImageButton = itemView.findViewById(R.id.imageButton3)

            name.text = "${transaction.name}"
            amount.text = "Amount: ${transaction.amount}€"

            edit.setOnClickListener{
                val intent = Intent(itemView.context, EditTransaction::class.java)
                intent.putExtra("TRANSACTION", transaction)
                itemView.context.startActivity(intent)
            }

            // Quitamos el listener del item para evitar que se abra DetallesActivity al hacer clic en el botón de edición
            // item.setOnClickListener{
            //     val intent = Intent(itemView.context, DetallesActivity::class.java)
            //     intent.putExtra("TRANSACTION", transaction)
            //     itemView.context.startActivity(intent)
            // }
        }
    }}