package com.example.marijaradisavljevic.restoran.database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Semaphore;

/**
 * Created by marija.radisavljevic on 5/18/2016.
 */
public class Rezervation implements  Cloneable{//TODO DB komunication

    private String time,name_user;
    private Integer price;
    private  Integer numberTable;
    private boolean paidOrNot;
   // private ArrayList<String> itemsOrder;


    private ArrayList<Order> orders;
    private int id;


    //TODO ovaj id treba da se dobija od backenda
    private static int ukid = 0;


    @Override
    public Rezervation clone() throws CloneNotSupportedException {
        Rezervation clone = new Rezervation();
         clone.setPaidOrNot(this.isPaidOrNot());
        clone.setTime(this.gettime());
        clone.setName_user(this.getname_user());
        clone.setNumberTable(this.getnumberTable());
        clone.id = this.id;

        Iterator<Order> iter = orders.iterator();
        ArrayList<Order>  cloneOrdersList = clone.getOrders();
        while (iter.hasNext()) {
            Order cloneOrder;
            Order tek = iter.next();


            cloneOrder = tek.clone();

            cloneOrdersList.add(cloneOrder);

        }


        return clone;
    }

    @Override
    public boolean equals(Object o) {
        Rezervation rez = (Rezervation)o;
        if(this.getId()== (rez.getId())) {
             return true;
        }
        return false;
    }

    public Rezervation() {

            orders = new ArrayList<Order>();

            //itemsOrder  = new ArrayList<String>();
            id = ukid++;

    }

    public String getnumberTable_string(){
        return Integer.toString(numberTable);
    }

    public boolean isPaidOrNot() {
        return paidOrNot;
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

    private void setPrice(int price) {
        this.price = price;
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

    public Integer getprice() {


            Iterator<Order> iter = orders.iterator();
            price = 0;
            while (iter.hasNext()) {
                price = price + iter.next().getOrder().getPrice();
            }



            return price;

    }

    public String getPrice_toString(){
        String bla = String.valueOf(getprice());
        return bla;
    }

   /* public ArrayList<String > getitemsOrder() {
        return itemsOrder;
    }
    public void setItemsOrder(ArrayList<String > itemsOrder) {
        this.itemsOrder = itemsOrder;
    }
*/
    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public String getItemsOrdersInString(){

            Iterator<Order> iter = orders.iterator();
            StringBuilder builder = new StringBuilder();
            while (iter.hasNext()) {
                builder.append(iter.next().getOrder().getFood());

            }

            return builder.toString();

    }
    public boolean ispaidOrNot() {
        return paidOrNot;
    }
}
