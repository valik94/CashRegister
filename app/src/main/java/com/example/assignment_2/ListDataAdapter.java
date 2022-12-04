package com.example.assignment_2;

import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class ListDataAdapter extends BaseAdapter {

    //list of purchases to render
    //the context - getView function needs View and inflator to convert xml into layout object/view object
    // this is done by creating a constructor that receives an arraylist of purchases and context

    ArrayList<Product> list;
    Context context;

    //input(list of products, the view (i.e. MainActivity.this) )
    public ListDataAdapter(ArrayList<Product> list, Context context){
        this.list = list;
        this.context = context; //not a syntax error
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
    public View getView(int position, View convertView, ViewGroup container) {
        //access LayoutInflater and access to context
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //convert the layout into view object 'view'
                                    //select layout view, viewGroup, false (garbage collector)
        View view = inflater.inflate(R.layout.list_row, container, false);

        TextView productType = view.findViewById(R.id.list_type);
        TextView productPrice = view.findViewById(R.id.list_price);
        TextView productQty = view.findViewById(R.id.list_quantity);

        productType.setText(list.get(position).type);
        productPrice.setText(String.valueOf(list.get(position).price));
        productQty.setText(String.valueOf(list.get(position).quantity));

        return view;

    }
}
