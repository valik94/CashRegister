package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView purchaseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView purchase_viewer = findViewById(R.id.purchase_list);

        String [] purchase_names = {"Pants", "Hats", "Shoes"};
        //Base Adapter instead

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.activity_main,
                R.id.product_textview,
                purchase_names);
        //creating a data transfer bridge between purchase_viewer the ListView in the UI and Adapter
        purchase_viewer.setAdapter(adapter);

    }
}

