package com.example.assignment_2;

import android.app.Application;

import java.util.ArrayList;

public class MyApp extends Application{
    //application data
    //2 array lists: 1 product type array list, 1 history type
    public ArrayList<Product> productlist = new ArrayList<>(0);
    public ArrayList<History> historyList = new ArrayList<>(0);

    //function that intializes the productList with hardcoded data
    public void setProductlistData(){
        if(productlist.isEmpty()){
            productlist.add(new Product("Shirts", 14.95, 22));
            productlist.add(new Product("Pants", 15.99, 20));
            productlist.add(new Product("Hats", 12.30, 15));
            productlist.add(new Product("Jeans", 29.99, 40));
            productlist.add(new Product("Dress-shirts", 24.99, 40));
            productlist.add(new Product("Socks", 2.99, 100));
        }
    }

}
