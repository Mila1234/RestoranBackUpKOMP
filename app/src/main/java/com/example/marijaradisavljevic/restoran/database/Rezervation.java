package com.example.marijaradisavljevic.restoran.database;

import java.util.ArrayList;

/**
 * Created by marija.radisavljevic on 5/18/2016.
 */
public class Rezervation {//TODO DB komunication

    private String time,name_user,numberTable,price,itemsOrder,paidOrNot;
    private ArrayList<String > itemsOrder;
    private int id;

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

    public void setNumberTable(String numberTable) {
        this.numberTable = numberTable;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setItemsOrder(ArrayList<String > itemsOrder) {
        this.itemsOrder = itemsOrder;
    }

    public void setPaidOrNot(String paidOrNot) {
        this.paidOrNot = paidOrNot;
    }

    public String gettime() {
        return time;
    }

    public String getname_user() {
        return name_user;
    }

    public String getnumberTable() {
        return numberTable;
    }

    public String getprice() {
        return price;
    }

    public ArrayList<String > getitemsOrder() {
        return itemsOrder;
    }

    public String getpaidOrNot() {
        return paidOrNot;
    }
}
