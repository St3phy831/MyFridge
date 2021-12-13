package com.example.myfridge.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfridge.R;

import java.util.List;

public class FridgeItemsAdapter extends RecyclerView.Adapter<FridgeItemsAdapter.ViewHolder>{

    public interface OnClick{
        void onItemClicked(int position);
    }
    public interface OnLongClick{
        void onItemLongClicked(int position);
    }

    List<String> fridgeItems;
    List<String> itemDates;
    RelativeLayout itemContainer;
    OnLongClick longClickListener;
    OnClick onClickListener;

    public FridgeItemsAdapter(List<String> fridgeItems, List<String> itemDates, OnLongClick longClickListener, OnClick onClickListener){
        this.fridgeItems = fridgeItems;
        this.itemDates = itemDates;
        this.longClickListener = longClickListener;
        this.onClickListener = onClickListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fridge_items, parent, false);
        itemContainer = listView.findViewById(R.id.itemContainer);
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
            itemContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //notify listener which item was clicked
                    onClickListener.onItemClicked(getAdapterPosition());
                }
            });
            itemContainer.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    //notify listener which item was clicked
                    longClickListener.onItemLongClicked(getAdapterPosition());
                    return true;
                }
            });
        }
    }
}
