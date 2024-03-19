package com.example.practica_m07_uf1

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView


class Adapter(private val itemList: List<Transaction>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.transactions, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transaction = itemList[position]
        holder.bind(transaction,itemList)
    }


    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(transaction: Transaction, itemList: List<Transaction>){
            val item: ConstraintLayout = itemView.findViewById(R.id.item)
            val name: TextView = itemView.findViewById(R.id.nameTextView)
            val amount: TextView = itemView.findViewById(R.id.amountTextView)

            name.text = "${transaction.name}"
            amount.text = "Amount: ${transaction.amount}€"

            item.setOnClickListener{
                val intent = Intent(itemView.context, DetallesActivity::class.java)
                intent.putExtra("TRANSACTION", transaction)
                itemView.context.startActivity(intent)

            }
        }



    }


}