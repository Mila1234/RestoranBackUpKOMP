package com.example.marijaradisavljevic.restoran.adapters;

/**
 * Created by marija.radisavljevic on 5/18/2016.
 */
public class ListData {//TODO DB komunication

    private String time,name_user,numberTable,price,itemsOrder,paidOrNot;

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

    public void setItemsOrder(String itemsOrder) {
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

    public String getitemsOrder() {
        return itemsOrder;
    }

    public String getpaidOrNot() {
        return paidOrNot;
    }
}
