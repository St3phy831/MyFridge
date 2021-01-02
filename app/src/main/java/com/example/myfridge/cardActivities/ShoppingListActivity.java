package com.example.myfridge.cardActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myfridge.R;
import com.example.myfridge.fragments.ShoppingListFragment;

public class ShoppingListActivity extends AppCompatActivity {
    EditText etItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        etItem = findViewById(R.id.etItem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit Item");
        etItem.setText(getIntent().getStringExtra(ShoppingListFragment.KEY_ITEM_TEXT));
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent with result
                Intent intent = new Intent();
                //pass data of result
                intent.putExtra(ShoppingListFragment.KEY_ITEM_TEXT, etItem.getText().toString());
                intent.putExtra(ShoppingListFragment.KEY_ITEM_POSITION, getIntent().getExtras().getInt(ShoppingListFragment.KEY_ITEM_POSITION));
                //set result
                setResult(RESULT_OK, intent);
                //finish activity to go back
                finish();
            }
        });
    }
}