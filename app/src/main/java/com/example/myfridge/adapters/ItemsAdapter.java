package com.example.myfridge.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfridge.R;

import java.util.List;

//display data from model in row of recycler view
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder>{

    public interface OnLongClickListener{
        void onItemLongClicked(int position);
    }
    List<String> items;
    OnLongClickListener longClickListener;

    public ItemsAdapter(List<String> items, OnLongClickListener longClickListener) {
        this.items = items;
        this.longClickListener = longClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //use layout inflater to inflate view
        View buyView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        //wrap it inside view holder and return it
        return new ViewHolder(buyView);
    }

    //taking data at particular position and putting into holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //grab item at position
        String item = items.get(position);
        //bind item to specified view holder
        holder.bind(item);

    }

    //Gets items available
    @Override
    public int getItemCount() {
        return items.size();
    }

    //container to provide easy access to view
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(android.R.id.text1);
        }

        //update the view inside the view holder with this data
        public void bind(String item) {
            tvItem.setText(item);

            tvItem.setOnLongClickListener(new View.OnLongClickListener() {
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
