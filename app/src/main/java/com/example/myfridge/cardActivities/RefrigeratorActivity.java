package com.example.myfridge.cardActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfridge.R;
import com.example.myfridge.adapters.FridgeItemsAdapter;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class RefrigeratorActivity extends AppCompatActivity {
    public static final String TAG = "RefrigeratorActivity";

    TextView tvTitle;
    String title;
    String color;
    String type;
    String added;
    String itemAdded;
    String dateAdded;
    List<String> items;
    List<String> dates;
    RecyclerView rvFridgeList;
    FridgeItemsAdapter fridgeItemsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refrigerator);

        Bundle data = getIntent().getExtras();

        color = data.getString("color");
        title = data.getString("title");
        items = data.getStringArrayList("items");
        dates = data.getStringArrayList("dates");
        type = data.getString("type");
        added = data.getString("added");
        itemAdded = data.getString("itemAdded");
        dateAdded = data.getString("dateAdded");

        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText(title);
        tvTitle.setTextColor(Color.parseColor(color));

        loadItems();

        FridgeItemsAdapter.OnLongClick longClick = new FridgeItemsAdapter.OnLongClick(){
            @Override
            public void onItemClicked(int position) {
                //Delete item
                items.remove(position);
                dates.remove(position);
                //notify adapter
                fridgeItemsAdapter.notifyItemRemoved(position);
                Toast.makeText(getApplicationContext(), "Item was deleted", Toast.LENGTH_SHORT).show();
                saveItems();
            }
        };

        rvFridgeList = findViewById(R.id.rvFridgeItems);
        fridgeItemsAdapter = new FridgeItemsAdapter(items, dates, longClick);
        rvFridgeList.setAdapter(fridgeItemsAdapter);
        rvFridgeList.setLayoutManager(new LinearLayoutManager(this));

        //This saves the items added
        if(added.equals("true")){
            items.add(itemAdded);
            dates.add(dateAdded);
            //notify adapter
            fridgeItemsAdapter.notifyItemInserted(items.size()-1);
            Toast.makeText(getApplicationContext(), "Item was added", Toast.LENGTH_SHORT).show();
            saveItems();
        }
    }
    //Checks which card view to save and load for appropriate date and item list.
    private File getDataFileForItem(String type){
        switch(type){
            case "Dairy":
                return new File(getFilesDir(), "dairyItems.txt");
            case "Veggie":
                return new File(getFilesDir(), "veggieItems.txt");
            case "Fruit":
                return new File(getFilesDir(), "fruitItems.txt");
            case "Drink":
                return new File(getFilesDir(), "drinkItems.txt");
            case "Meat":
                return new File(getFilesDir(), "meatItems.txt");
            case "Other":
            default:
                return new File(getFilesDir(), "otherItems.txt");
        }
    }
    private File getDataFileForDate(String type){
        switch(type){
            case "Dairy":
                return new File(getFilesDir(), "dairyDate.txt");
            case "Veggie":
                return new File(getFilesDir(), "veggieDate.txt");
            case "Fruit":
                return new File(getFilesDir(), "fruitDate.txt");
            case "Drink":
                return new File(getFilesDir(), "drinkDate.txt");
            case "Meat":
                return new File(getFilesDir(), "meatDate.txt");
            case "Other":
            default:
                return new File(getFilesDir(), "otherDate.txt");
        }
    }
    //This function will load items by reading every line on data file
    public void loadItems() {
        try {
            items = new ArrayList<>(FileUtils.readLines(getDataFileForItem(type), Charset.defaultCharset()));
            dates = new ArrayList<>(FileUtils.readLines(getDataFileForDate(type), Charset.defaultCharset()));
        } catch (IOException e) {
            Log.e(TAG, "Error reading items", e);
            //initializes array list if empty
            items = new ArrayList<>();
            dates = new ArrayList<>();
        }
    }
    //function saves items by saving items on data file
    private void saveItems(){
        try {
            FileUtils.writeLines(getDataFileForItem(type), items);
            FileUtils.writeLines(getDataFileForDate(type), dates);
        } catch (IOException e) {
            Log.e(TAG, "Error writing items", e);
        }
    }
}
