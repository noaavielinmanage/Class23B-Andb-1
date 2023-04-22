package com.guy.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ExpenseHolder> {
    private List<DataTable> expenses = new ArrayList<>();
    OnItemClickListner listner;

    @NonNull
    @Override
    public ExpenseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_item, parent, false);
        return new ExpenseHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseHolder holder, int position) {
        DataTable expenseTable = expenses.get(position);
        holder.expenseName.setText(expenseTable.getExpenseName());
        holder.desc.setText(expenseTable.getDescription());
        holder.amount.setText(expenseTable.getAmount());
        holder.date.setText(expenseTable.getDate());


    }

    public void setNotes(List<DataTable> expenses) {
        this.expenses = expenses;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if(expenses!=null)
            return expenses.size();
        return 0;
    }

    class ExpenseHolder extends RecyclerView.ViewHolder {
        private TextView expenseName;
        private TextView amount;
        private TextView desc;
        private TextView date;

        public ExpenseHolder(View view) {
            super(view);
            expenseName = view.findViewById(R.id.expenseName);
            amount = view.findViewById(R.id.amount);
            desc = view.findViewById(R.id.desc);
            date = view.findViewById(R.id.date);

            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listner != null && position != RecyclerView.NO_POSITION)
                        listner.onItemClick(expenses.get(position));
                }
            });
        }
    }

    public interface OnItemClickListner {
        void onItemClick(DataTable data);
    }

}

