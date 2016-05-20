package com.example.marijaradisavljevic.restoran.database;

import java.util.ArrayList;

/**
 * Created by marija.radisavljevic on 5/20/2016.
 */
public class Order {
    private ArrayList<String> listOrder;
    private String time;
    private boolean paidOrNot;
    private int numbreOfTable_spinner;

    public Order( String time, boolean paidOrNot,int numbreOfTable_spinner) {
        this.numbreOfTable_spinner = numbreOfTable_spinner;
        this.time = time;
        this.paidOrNot = paidOrNot;
    }

    public Order() {

    }



    public void addOrderItem(String name){
        listOrder.add(name);
    }

    public ArrayList<String> getListOrder() {
        return listOrder;
    }

    public void setListOrder(ArrayList<String> listOrder) {
        this.listOrder = listOrder;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
//
    /*
    public boolean isSplit_order() {
        return split_order;
    }

    public void setSplit_order(boolean split_order) {
        this.split_order = split_order;
    }

    public boolean isMake_order() {
        return make_order;
    }

    public void setMake_order(boolean make_order) {
        this.make_order = make_order;
    }

    public boolean isNew_item() {
        return new_item;
    }

    public void setNew_item(boolean new_item) {
        this.new_item = new_item;
    }
    */
    //

    public boolean isPaidOrNot() {
        return paidOrNot;
    }

    public void setPaidOrNot(boolean paidOrNot) {
        this.paidOrNot = paidOrNot;
    }

    public int getNumbreOfTable_spinner() {
        return numbreOfTable_spinner;
    }

    public void setNumbreOfTable_spinner(int numbreOfTable_spinner) {
        this.numbreOfTable_spinner = numbreOfTable_spinner;
    }
}
