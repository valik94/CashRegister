package com.example.assignment_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class HistoryRecyclerAdapter extends RecyclerView.Adapter<HistoryRecyclerAdapter.myViewHolder> {

    interface ItemListener {
        void onItemClicked(int pos);
    }

    ArrayList<History> list;
    Context context;
    ItemListener listener;

    public HistoryRecyclerAdapter(ArrayList<History> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_history_row, parent, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.historyType.setText(list.get(position).getType());
        holder.historyPrice.setText(String.valueOf(list.get(position).getPrice()));
        holder.historyQuantity.setText(String.valueOf(list.get(position).getQuantity()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView historyType;
        TextView historyPrice;
        TextView historyQuantity;

        public myViewHolder(@NonNull View itemView) { //mandatory vs optional -- NonNull input
            super(itemView);

            historyType = itemView.findViewById(R.id.history_type);
            historyPrice = itemView.findViewById(R.id.history_price);
            historyQuantity = itemView.findViewById(R.id.history_quantity);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onItemClicked(getAdapterPosition());
        }
    }
}