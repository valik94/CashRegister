package com.example.assignment_2;

import static java.lang.Double.parseDouble;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    Button one, two, three, four, five, six, seven, eight, nine, zero, clear, buy, managerBtn;
    TextView typeTV, quantityTV, totalTV;
    ListDataAdapter adapter;
    Double total = 0.0;
    ListView itemsListView;
    int index = -1;
    ArrayList<Product> stockList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup data source
        initViews();
        setClickListeners();
        setListData();

        itemsListView.setOnItemClickListener(this);

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
    private void setListData() {
        ((MyApp) getApplication()).setProductlistData();

        stockList = ((MyApp) getApplication()).productlist;
        //declares and sets basic list data adapter to adapter with list and context
        adapter = new ListDataAdapter(((MyApp) getApplication()).productlist, MainActivity.this);
        //itemListView.setAdapter(adapter) binds adapter to the itemsListView
        itemsListView.setAdapter(adapter);
    }

    private void initViews() {
        typeTV = findViewById(R.id.product_textview);
        quantityTV = findViewById(R.id.quantity_tv);
        totalTV = findViewById(R.id.total_tv);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        clear = findViewById(R.id.clear_but);
        buy = findViewById(R.id.buttonBuy);
        managerBtn = findViewById(R.id.buttonManager);
        itemsListView = findViewById(R.id.listview_products);

    }


    @Override //implementation of override mandatory function/method of onclick listener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonBuy: //Buy Button
                //check if total textview is not empty
                if (!totalTV.getText().toString().equals("")) {
                     showAlert(); //showalert is the buy dialog
                } else {
                    Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.clear_but: //Clear Button
                quantityTV.setText("");
                quantityTV.setHint("Quantity");
                totalTV.setText("");
                totalTV.setHint("Total");
                typeTV.setText("");
                typeTV.setHint("Product Type");
                break;
            case R.id.buttonManager: //Button Manager
                Intent intentManager = new Intent(MainActivity.this, ManagerActivity.class);
                startActivity(intentManager);
                break;
            default: //the exception default buttons 1,2,3,4,5,6,7,8,9,0
                Button b = (Button) view;
                String num1 = quantityTV.getText().toString(); // by default quantity text is empty

                //assign text from button to num2
                String num2 = b.getText().toString();
                //concatenate num1 "" and num2
                String num = num1 + num2;

                if (index != -1) {
                    Double price = stockList.get(index).getPrice();
                    total = price * parseDouble(num);
                    totalTV.setText(String.format("%.2f", total));
                }
                quantityTV.setText(String.format("%s%s", num1, num2));

                if (Integer.parseInt(quantityTV.getText().toString()) > stockList.get(index).getQuantity()) {
                    Toast.makeText(this, "No enough quantity in the stock", Toast.LENGTH_SHORT).show();;
                    //resets quantity, productType and total textViews to blank
                    quantityTV.setText("");
                    quantityTV.setHint("Quantity");
                    totalTV.setText("");
                    totalTV.setHint("Total");
                    typeTV.setText("");
                    typeTV.setHint("Product Type");
                }
        }

    }

    @Override
    //i is index value of item clicked
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        typeTV.setText(stockList.get(i).getType());
        index = i; //save index value because we reuse it
        if (!quantityTV.getText().toString().equals("")) { //check if user clicked any number button before
            //then count the quantity and multiplied the productList (data price) resulting in type casting to type double total
            total = parseDouble(quantityTV.getText().toString()) * stockList.get(i).getPrice();
            //shorten the textview price in string using String.format and 2 decimal places
            totalTV.setText(String.format("%.2f", total));
        }

    }

    private void showAlert() { //Buy confirmation Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //show/notify the user you have bought the item
        builder.setMessage("Your purchase is " + quantityTV.getText().toString() + " " + stockList.get(index).getType() + " for " + totalTV.getText().toString())
                .setTitle("Thank You for your purchase");
        //OK Button
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            //setonClikcListener to Ok Button
            public void onClick(DialogInterface dialog, int id) {
                // open a report activity
                //reset the textfields/textViews
                quantityTV.setText("");
                quantityTV.setHint("Quantity");
                totalTV.setText("");
                totalTV.setHint("Total");
                typeTV.setText("");
                typeTV.setHint("Product Type");
            }
        });
        //create is to create the dialog and .show is to display the dialog to the user
        builder.create().show();
        Product obj = ((MyApp) getApplication()).productlist.get(index);
        //Update the quantity value of objects available in stock
        //get quantity - integer type cast of quantityTextview chosen by user
        //for example 10 - 2
        obj.setQuantity(obj.getQuantity() - Integer.parseInt(quantityTV.getText().toString()));
        //Update display quantity now in the list, List.set( the row number of the List, and overwrite obj quantity)
        ((MyApp) getApplication()).productlist.set(index, obj);

        //Display changes to the user **IMPORTANT**
        //Every time we modify the list, we have to notify the adapter the list has changed with the new list
        adapter.notifyDataSetChanged(); //it will run the adapter again and update its new list values

        //Part 2 starts
        Date d1 = new Date();
        History h1 = new History(obj.getType(), parseDouble(totalTV.getText().toString()), Integer.parseInt(quantityTV.getText().toString()), d1);
        ((MyApp) getApplication()).historyList.add(h1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

}

