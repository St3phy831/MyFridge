package com.example.myfridge.cardActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myfridge.R;
import com.example.myfridge.adapters.FridgeItemsAdapter;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class RefrigeratorActivity extends AppCompatActivity {
    TextView tvTitle;
    String title;
    String color;
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

        tvTitle = findViewById(R.id.tvTitle);
        title = data.getString("title");

        tvTitle.setText(title);
        tvTitle.setTextColor(Color.parseColor(color));

        items = data.getStringArrayList("items");
        dates = data.getStringArrayList("dates");

        rvFridgeList = findViewById(R.id.rvFridgeItems);
        fridgeItemsAdapter = new FridgeItemsAdapter(items, dates);
        rvFridgeList.setAdapter(fridgeItemsAdapter);
        rvFridgeList.setLayoutManager(new LinearLayoutManager(this));

    }
}
