package com.example.myfridge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.action_list:
                        Toast.makeText(getApplicationContext(), "ToBuy List", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_add:
                        Toast.makeText(getApplicationContext(), "Add to List", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_fridge:
                    default:
                        Toast.makeText(getApplicationContext(), "Fridge List", Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });
        //Set Default selection
        bottomNavigationView.setSelectedItemId(R.id.action_list);
    }
}