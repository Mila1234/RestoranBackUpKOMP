package com.example.marijaradisavljevic.restoran.database;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by marija.radisavljevic on 5/20/2016.
 */
public class AdapterDB {

    private static AdapterDB instance = new AdapterDB();
    public static AdapterDB getInstance() {return instance; }

    public AdapterDB() {
        listOfRezervations = new ArrayList<Rezervation>();


        Rezervation ld = new Rezervation();
        ld.setId(1);
        ld.setName_user("milica jelic");
        ld.setItemsOrder(new ArrayList(Arrays.asList("kapucino , truska kafa, lenja pita sa jabukama")));
        ld.setNumberTable(3);
        ld.setPaidOrNot(true);
        ld.setPrice("540 rsd");
        ld.setTime("5.5.2016. 17:30 ");
        listOfRezervations.add(ld);

         ld = new Rezervation();
        ld.setId(6);
        ld.setName_user("Ana Ilic");
        ld.setItemsOrder(new ArrayList(Arrays.asList("kapucino , truska kafa, lenja pita sa jabukama")));
        ld.setNumberTable(2);
        ld.setPaidOrNot(true);
        ld.setPrice("700 rsd");
        ld.setTime("5.5.2016. 18:30 ");
        listOfRezervations.add(ld);

        ld = new Rezervation();
        ld.setId(55);
        ld.setName_user("milanka rajicic");
        ld.setItemsOrder(new ArrayList(Arrays.asList("koka kola , koka kola, lenja pita sa jabukama")));
        ld.setNumberTable(2);
        ld.setPaidOrNot(true);
        ld.setPrice("350 rsd");
        ld.setTime("5.5.2016. 18:00");
        listOfRezervations.add(ld);


        ld = new Rezervation();
        ld.setName_user("novak stojanovic");
        ld.setItemsOrder(new ArrayList(Arrays.asList("jelen pivo ,crveno vino , lenja pita sa jabukama")));
        ld.setNumberTable(1);
        ld.setId(998);
        ld.setPaidOrNot(true);
        ld.setPrice("690 rsd");
        ld.setTime("5.5.2016. 17:00 ");
        listOfRezervations.add(ld);

    }

    //i get list of reservatins from back end
private ArrayList<Rezervation> listOfRezervations;

    //TODO 5/19/2016  this  is read from DB
    public ArrayList<Rezervation> getRezervations() {
        return  listOfRezervations;
    }

    public void updateRezervations (int id){


    }

    public void  deleteRezervation(int id){

    }



    public Rezervation getClickActionRezervation(int pozition){
        return  listOfRezervations.get(pozition);
    }

    public Rezervation getNewRezervation() {
        Rezervation r = new Rezervation();
        listOfRezervations.add(r);
        return r;
    }
}
