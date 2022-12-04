package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button one, two, three, four, five, six, seven, eight, nine, zero, clear, buy, managerBtn;
    TextView typeTV, quantityTV, totalTV;
//    ListDataAdapter adapter;
    Double total = 0.0;
    ListView itemsListView;
    int index = -1;
    ArrayList<Product> stockList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView purchase_viewer = findViewById(R.id.listview_products);

        String [] purchase_names = {"Pants", "Hats", "Shoes"};
        //Base Adapter instead

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.activity_main,
                R.id.product_textview,
                purchase_names);
        //creating a data transfer bridge between purchase_viewer the ListView in the UI and Adapter
        purchase_viewer.setAdapter(adapter);
    }


    private void setClickListeners() {
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        buy.setOnClickListener(this);
        clear.setOnClickListener(this);
        managerBtn.setOnClickListener(this);
    }

    //every time a user creates a purchase we must save it and the stockList of items needs to exist
    private void setListData(){
        //((MyApp) getApplication()).setProductListData();

        stockList = ((MyApp) getApplication()).productlist;

    }


    @Override
    public void onClick(View view) {

    }
}

