package com.example.marijaradisavljevic.restoran.database;

/**
 * Created by marija on 22.5.16.
 */
public class FoodMenuItem {
    private String food;
    private int price;
    private int id;
    //TODO dobija se od baceknda
    private static int ukid = 0;

    public FoodMenuItem(String food, int price) {
        this.food = food;
        this.price = price;
        id = ukid++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getPrice() {
        return price;
    }

    private void setPrice(int price) {
        this.price = price;
    }
}
