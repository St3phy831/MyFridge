package com.example.myfridge.cardActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myfridge.R;
import com.example.myfridge.fragments.ShoppingListFragment;

public class EditActivity extends AppCompatActivity {
    EditText etItem;
    Button btnSave;
    String text;
    String position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        getSupportActionBar().setTitle("Edit Item");

        etItem = findViewById(R.id.etItem);
        btnSave = findViewById(R.id.btnSave);

        if (getIntent().getExtras().getInt("code") == 20)
        {
            text = ShoppingListFragment.KEY_ITEM_TEXT;
            position = ShoppingListFragment.KEY_ITEM_POSITION;
        }
        if (getIntent().getExtras().getInt("code") == 17)
        {
            text = RefrigeratorActivity.KEY_ITEM_TEXT;
            position = RefrigeratorActivity.KEY_ITEM_POSITION;
        }

        etItem.setText(getIntent().getStringExtra(text));
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent with result
                Intent intent = new Intent();
                //pass data of result
                intent.putExtra(text, etItem.getText().toString());
                intent.putExtra(position, getIntent().getExtras().getInt(position));
                //set result
                setResult(RESULT_OK, intent);
                //finish activity to go back
                finish();
            }
        });
    }
}