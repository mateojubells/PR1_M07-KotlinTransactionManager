package com.example.database_api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practica_m07_uf1.R
import com.example.practica_m07_uf1.Transaction


class Adapter(private val itemList: List<Transaction>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.nameTextView)
        val amount: TextView = itemView.findViewById(R.id.amountTextView)
        val date: TextView = itemView.findViewById(R.id.dateTextView)
        val type: TextView = itemView.findViewById(R.id.typeTextView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.transactions, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val transaction = itemList[position]
        holder.name.text = "Name: ${transaction.name}"
        holder.amount.text = "Amount: ${transaction.amount}"
        holder.date.text = "Date: ${transaction.date}"
        holder.type.text = "Type: ${transaction.type}"
    }
    override fun getItemCount(): Int {
        return itemList.size
    }
}