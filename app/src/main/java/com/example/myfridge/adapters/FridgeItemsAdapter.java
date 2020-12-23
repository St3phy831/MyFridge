package com.example.myfridge.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfridge.R;

import java.util.List;

public class FridgeItemsAdapter extends RecyclerView.Adapter<FridgeItemsAdapter.ViewHolder>{
    List<String> fridgeItems;
    List<String> itemDates;

    public FridgeItemsAdapter(List<String> fridgeItems, List<String> itemDates){
        this.fridgeItems = fridgeItems;
        this.itemDates = itemDates;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fridge_items, parent, false);
        return new ViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = fridgeItems.get(position);
        String date = itemDates.get(position);
        holder.bind(item, date);

    }

    @Override
    public int getItemCount() {
        return fridgeItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvFridgeItem;
        TextView tvDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFridgeItem = itemView.findViewById(R.id.tvFridgeItem);
            tvDate = itemView.findViewById(R.id.tvDate);
        }

        public void bind(String item, String date) {
            tvFridgeItem.setText(item);
            tvDate.setText(date);
        }
    }
}
