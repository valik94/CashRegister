package com.example.assignment_2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;


public class ListDataAdapter extends BaseAdapter {

    //list of donations to render
    //the context - getView function needs View and inflator to convert xml into layout object/view object
    // this is done by creating a constructor that receives an arraylist of purchases and context

    ArrayList<Product> list;
    Context context;

    //input(list of products, the view (i.e. MainActivity.this) )
    public ListDataAdapter(ArrayList<Product> list, Context context){
        this.list = list;
        this.context = context;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
