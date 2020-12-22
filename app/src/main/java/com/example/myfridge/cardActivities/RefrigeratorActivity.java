package com.example.myfridge.cardActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myfridge.R;

public class RefrigeratorActivity extends AppCompatActivity {
    TextView tvTitle;
    String title;
    String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refrigerator);

        Bundle data = getIntent().getExtras();
        color = data.getString("color");

        tvTitle = findViewById(R.id.tvTitle);
        title = getIntent().getStringExtra("title");
        tvTitle.setText(title);
        tvTitle.setTextColor(Color.parseColor(color));
    }
}
