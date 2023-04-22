package com.guy.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.guy.common.DataAdapter.OnItemClickListner


private class AllTransactionsAdapter : RecyclerView.Adapter<AllTransactionsAdapter.ExpenseHolder>() {
    private var expenses: List<DataTable> = ArrayList()
    var clickListener: OnItemClickListner? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.data_all_items, parent, false)
        return ExpenseHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExpenseHolder, position: Int) {
        val expenseTable = expenses[position]
        holder.expenseName.text = expenseTable.expenseName
        holder.desc.text = expenseTable.description
        holder.amount.text = expenseTable.amount
        holder.date.text = expenseTable.date
    }

    fun setNotes(expenses: List<DataTable>) {
        this.expenses = expenses
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return expenses.size
    }

    internal inner class ExpenseHolder(view: View) : RecyclerView.ViewHolder(view) {
        val expenseName: TextView
        val amount: TextView
        val desc: TextView
        val date: TextView

        init {
            expenseName = view.findViewById(R.id.expenseName)
            amount = view.findViewById(R.id.amount)
            desc = view.findViewById(R.id.desc)
            date = view.findViewById(R.id.date)
            view.setOnClickListener {
                val position = adapterPosition
                if (clickListener != null && position != RecyclerView.NO_POSITION) clickListener!!.onItemClick(
                    expenses[position]
                )
            }
        }
    }
}