package com.example.assignment_2;

import java.util.Date;

public class History {
    String type;
    Double price;
    int quantity;
    Date date;

    public History(String type, Double price, int quantity, Date date){
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
    }

    public Date getDate(){ return date; }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() { return price;}

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


        @Override
        public String toString() {
            return "History: " +
                    "date=" + date +
                    " type='" + type  +
                    " price=" + price +
                    " quantity=" + quantity;
        }
    }
