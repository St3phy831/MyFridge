package com.example.myfridge.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfridge.R;
import com.example.myfridge.adapters.ItemsAdapter;
import com.example.myfridge.cardActivities.EditActivity;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingListFragment extends Fragment {
    public static final String KEY_ITEM_TEXT = "item_text";
    public static final String KEY_ITEM_POSITION = "item_position";
    public static final String CODE = "code";
    public static final int EDIT_CODE = 20;
    public static final int RESULT_OK = -1;

    private static final String TAG = "ShoppingList";
    List<String> items;
    Button btnAdd;
    EditText etItem;
    RecyclerView rvItems;
    ItemsAdapter itemsAdapter;



    public ShoppingListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shopping_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnAdd = view.findViewById(R.id.btnAdd);
        etItem = view.findViewById(R.id.etItem);
        rvItems = view.findViewById(R.id.rvItems);

        loadItems();

        ItemsAdapter.OnLongClickListener longClickListener = new ItemsAdapter.OnLongClickListener(){
            @Override
            public void onItemLongClicked(int position) {
                //Delete item
                items.remove(position);
                //notify adapter
                itemsAdapter.notifyItemRemoved(position);
                Toast.makeText(getContext(), "Deleted", Toast.LENGTH_SHORT).show();
                saveItems();

            }
        };

        ItemsAdapter.OnClickListener onClickListener = new ItemsAdapter.OnClickListener() {
            @Override
            public void onItemClicked(int position) {
                //Create activity
                Intent i = new Intent(getActivity(), EditActivity.class);
                //pass the data
                i.putExtra(KEY_ITEM_TEXT, items.get(position));
                i.putExtra(KEY_ITEM_POSITION, position);
                i.putExtra(CODE, EDIT_CODE);
                //display activity
                startActivityForResult(i, EDIT_CODE);
                Log.d(TAG, "Single click at position" + position);
            }
        };

        itemsAdapter = new ItemsAdapter(items, longClickListener, onClickListener);
        rvItems.setAdapter(itemsAdapter);
        rvItems.setLayoutManager(new LinearLayoutManager(getContext()));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buyItem = etItem.getText().toString();
                if(buyItem.isEmpty()){
                    Toast.makeText(getContext(), "Can't be Empty", Toast.LENGTH_SHORT).show();
                }else {
                    //add item to model
                    items.add(buyItem);
                    //Notify adapter something added
                    itemsAdapter.notifyItemInserted(items.size() - 1);
                    //clear text
                    etItem.setText("");
                    //Saves
                    saveItems();
                    Toast.makeText(getContext(), "Added", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //handle data of result
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK && requestCode == EDIT_CODE){
            //retrieve updated text value
            String itemText = data.getStringExtra(KEY_ITEM_TEXT);
            //extract original position of edited item from position key
            int position = data.getExtras().getInt(KEY_ITEM_POSITION);
            //update model with new item
            items.set(position, itemText);
            //notify adapter
            itemsAdapter.notifyItemChanged(position);
            //persists
            saveItems();
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }else{
            Log.w(TAG, "Unknown call to " + TAG);
        }
    }

    private File getDataFile(){
        return new File(getActivity().getCacheDir(), "data.txt");
    }

    //This function will load items by reading every line on data file
    public void loadItems() {
        try {
            items = new ArrayList<>(FileUtils.readLines(getDataFile(), Charset.defaultCharset()));
        } catch (IOException e) {
            Log.e(TAG, "Error reading items", e);
            //initializes array list if empty
            items = new ArrayList<>();
        }
    }

    //function saves items by saving items on data file
    private void saveItems(){
        try {
            FileUtils.writeLines(getDataFile(), items);
        } catch (IOException e) {
            Log.e(TAG, "Error writing items", e);
        }
    }
}