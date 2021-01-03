package com.example.myfridge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myfridge.fragments.ComposeFragment;
import com.example.myfridge.fragments.RefrigeratorFragment;
import com.example.myfridge.fragments.ShoppingListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    final FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                //Must set all of them to Shopping list Fragment so it can compile and run
                switch(menuItem.getItemId()){
                    case R.id.action_list:
                        fragment = new ShoppingListFragment();
                        Toast.makeText(getApplicationContext(), "Shopping List", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_add:
                        fragment = new ComposeFragment();
                        Toast.makeText(getApplicationContext(), "Add to Fridge", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_fridge:
                    default:
                        fragment = new RefrigeratorFragment();
                        Toast.makeText(getApplicationContext(), "Fridge", Toast.LENGTH_SHORT).show();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        //Set Default selection
        bottomNavigationView.setSelectedItemId(R.id.action_fridge);

    }
}