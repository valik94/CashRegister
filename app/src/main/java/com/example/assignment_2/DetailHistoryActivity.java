package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_history);

        TextView typeTV=(TextView) findViewById(R.id.myType);
        TextView priceTV=(TextView) findViewById(R.id.myPrice);
        TextView dateTV=(TextView) findViewById(R.id.myDate);
        int  index=getIntent().getIntExtra("Index",0);
        History h1=((MyApp) getApplication()).historyList.get(index);
        typeTV.setText(String.format("%s%s", typeTV.getText().toString(), h1.getType()));
        priceTV.setText(String.format("%s%s", priceTV.getText().toString(), String.valueOf(h1.getPrice())));
        dateTV.setText(String.format("%s%s", dateTV.getText().toString(), String.valueOf(h1.getDate())));

    }
}