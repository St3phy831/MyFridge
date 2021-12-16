package com.example.myfridge.cardActivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfridge.R;
import com.example.myfridge.adapters.FridgeItemsAdapter;
import com.example.myfridge.fragments.RefrigeratorFragment;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class RefrigeratorActivity extends AppCompatActivity {
    public static final String TAG = "RefrigeratorActivity";
    public static final String KEY_ITEM_TEXT = "item_text";
    public static final String KEY_ITEM_POSITION = "item_position";
    public static final String CODE = "code";
    public static final int EDIT_CODE = 17;
    public static final int RESULT_OK = -1;

    TextView tvTitle;
    String title;
    String color;
    String type;
    Boolean added;
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

        color = data.getString(RefrigeratorFragment.COLOR);
        title = data.getString(RefrigeratorFragment.TITLE);
        items = data.getStringArrayList(RefrigeratorFragment.ITEMS);
        dates = data.getStringArrayList(RefrigeratorFragment.DATES);
        type = data.getString(RefrigeratorFragment.TYPE);
        added = data.getBoolean(RefrigeratorFragment.ADDED);
        itemAdded = data.getString(RefrigeratorFragment.ITEM_ADDED);
        dateAdded = data.getString(RefrigeratorFragment.DATE_ADDED);

        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText(title);
        tvTitle.setTextColor(Color.parseColor(color));

        loadItems();

        FridgeItemsAdapter.OnLongClick longClick = new FridgeItemsAdapter.OnLongClick(){
            @Override
            public void onItemLongClicked(int position) {
                //Delete item
                items.remove(position);
                dates.remove(position);
                //notify adapter
                fridgeItemsAdapter.notifyItemRemoved(position);
                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
                saveItems();
            }
        };

        FridgeItemsAdapter.OnClick onClick = new FridgeItemsAdapter.OnClick() {
            @Override
            public void onItemClicked(int position) {
                //Create activity
                Intent i = new Intent(RefrigeratorActivity.this, EditActivity.class);
                //pass the data
                i.putExtra(KEY_ITEM_TEXT, items.get(position));
                i.putExtra(KEY_ITEM_POSITION, position);
                i.putExtra(CODE, EDIT_CODE);
                //display activity
                startActivityForResult(i, EDIT_CODE);
                Log.d(TAG, "Single CLick at position" + position);
            }
        };

        rvFridgeList = findViewById(R.id.rvFridgeItems);
        fridgeItemsAdapter = new FridgeItemsAdapter(items, dates, longClick, onClick);
        rvFridgeList.setAdapter(fridgeItemsAdapter);
        rvFridgeList.setLayoutManager(new LinearLayoutManager(this));

        //This saves the items added
        if(added.equals(RefrigeratorFragment.WAS_ADDED)){
            items.add(itemAdded);
            dates.add(dateAdded);
            //notify adapter
            fridgeItemsAdapter.notifyItemInserted(items.size()-1);
            Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();
            saveItems();
        }
    }
    //handle data of result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == EDIT_CODE) {
            //retrieve updated text value
            String itemText = data.getStringExtra(KEY_ITEM_TEXT);
            //extract original position of edited item from position key
            int position = data.getExtras().getInt(KEY_ITEM_POSITION);
            //update model with new item
            items.set(position, itemText);
            //notify adapter
            fridgeItemsAdapter.notifyItemChanged(position);
            //persists
            saveItems();
            Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
        } else {
            Log.w(TAG, "Unknown call to " + TAG);
        }
    }

    //Checks which card view to save and load for appropriate date and item list.
    private File getDataFileForItem(String type){
        switch(type){
            case RefrigeratorFragment.CATEGORY_ONE:
                return new File(getFilesDir(), "dairyItems.txt");
            case RefrigeratorFragment.CATEGORY_TWO:
                return new File(getFilesDir(), "veggieItems.txt");
            case RefrigeratorFragment.CATEGORY_THREE:
                return new File(getFilesDir(), "fruitItems.txt");
            case RefrigeratorFragment.CATEGORY_FOUR:
                return new File(getFilesDir(), "drinkItems.txt");
            case RefrigeratorFragment.CATEGORY_FIVE:
                return new File(getFilesDir(), "meatItems.txt");
            case RefrigeratorFragment.CATEGORY_SIX:
            default:
                return new File(getFilesDir(), "otherItems.txt");
        }
    }
    private File getDataFileForDate(String type){
        switch(type){
            case RefrigeratorFragment.CATEGORY_ONE:
                return new File(getFilesDir(), "dairyDate.txt");
            case RefrigeratorFragment.CATEGORY_TWO:
                return new File(getFilesDir(), "veggieDate.txt");
            case RefrigeratorFragment.CATEGORY_THREE:
                return new File(getFilesDir(), "fruitDate.txt");
            case RefrigeratorFragment.CATEGORY_FOUR:
                return new File(getFilesDir(), "drinkDate.txt");
            case RefrigeratorFragment.CATEGORY_FIVE:
                return new File(getFilesDir(), "meatDate.txt");
            case RefrigeratorFragment.CATEGORY_SIX:
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
