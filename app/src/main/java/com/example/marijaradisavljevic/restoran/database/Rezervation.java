package com.example.marijaradisavljevic.restoran.database;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by marija.radisavljevic on 5/18/2016.
 */
public class Rezervation {//TODO DB komunication

    private String time,name_user,price;
    private  int numberTable;
    private boolean paidOrNot;
    private ArrayList<String> itemsOrder;
    private int id;


    public Rezervation() {
        itemsOrder  = new ArrayList<String>();
    }

    public String getnumberTable_string(){
        return Integer.toString(numberTable);
    }

    public String getpaidOrNot_string(){
        if (paidOrNot) {
            return "paid";
        }else{
            return "not paid";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public void setNumberTable(int numberTable) {
        this.numberTable = numberTable;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setItemsOrder(ArrayList<String > itemsOrder) {
        this.itemsOrder = itemsOrder;
    }

    public void setPaidOrNot(boolean paidOrNot) {
        this.paidOrNot = paidOrNot;
    }

    public String gettime() {
        return time;
    }

    public String getname_user() {
        return name_user;
    }

    public int getnumberTable() {
        return numberTable;
    }

    public String getprice() {
        return price;
    }

    public ArrayList<String > getitemsOrder() {
        return itemsOrder;
    }


    public String getItemsOrdersInString(){
        Iterator<String> iter = itemsOrder.iterator();
        StringBuilder builder = new StringBuilder();
        while(iter.hasNext()){
            builder.append(iter.next());

        }
        return builder.toString();
    }
    public boolean ispaidOrNot() {
        return paidOrNot;
    }
}
