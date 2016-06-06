package com.example.marijaradisavljevic.restoran.servis;

import com.example.marijaradisavljevic.restoran.database.FoodMenuItem;
import com.example.marijaradisavljevic.restoran.database.Order;
import com.example.marijaradisavljevic.restoran.database.Rezervation;
import com.example.marijaradisavljevic.restoran.database.SelecionRegulations;

import java.util.ArrayList;

/**
 * Created by marija.radisavljevic on 6/3/2016.
 */
public class Servis {
    private static Servis instance = new Servis();
    public static Servis getInstance() {return instance; }


    private String[] listaTable;
    private ArrayList<FoodMenuItem> listFoodMenuItem;
    private ArrayList<Rezervation> listOfRezervations;


    public Servis() {

        listaTable = new String[6];
        listaTable[0] = "broj stola";
        listaTable[1] ="1" ;
        listaTable[2] ="2";
        listaTable[3] ="3";
        listaTable[4] ="4";
        listaTable[5] = "5";


        listFoodMenuItem = new ArrayList<FoodMenuItem>();

        FoodMenuItem fmt1 = new FoodMenuItem("koka kolabla bla bla bla bla", 100);
        listFoodMenuItem.add(fmt1);
        FoodMenuItem fmt2 = new FoodMenuItem("koka kola", 100);
        listFoodMenuItem.add(fmt2);

        FoodMenuItem fmt3 = new FoodMenuItem("turska kafa", 100);
        listFoodMenuItem.add(fmt3);

        FoodMenuItem fmt4 = new FoodMenuItem("espreso", 100);
        listFoodMenuItem.add(fmt4);







        listOfRezervations = new ArrayList<Rezervation>();


        Rezervation ld = new Rezervation();

        ld.setName_user("milica jelic");
        // ld.setItemsOrder(new ArrayList(Arrays.asList("kapucino , truska kafa, lenja pita sa jabukama")));
        ArrayList<Order>listOrders = new ArrayList<Order>();
        listOrders.add(new Order(1,fmt1,1));
        listOrders.add(new Order(3,fmt2,1));
        listOrders.add(new Order(4,fmt3,1));
        listOrders.add(new Order(1,fmt1,1));
        listOrders.add(new Order(3,fmt2,1));
        listOrders.add(new Order(4,fmt3,1));
        listOrders.add(new Order(1,fmt1,1));
        listOrders.add(new Order(3,fmt2,1));
        listOrders.add(new Order(4,fmt3,1));
        ld.setOrders(listOrders);
        ld.setNumberTable(3);
        ld.setPaidOrNot(true);

        ld.setTime("5.5.2016. 17:30 ");
        ld.setId(555);
        listOfRezervations.add(ld);

        ld = new Rezervation();

        ld.setName_user("Ana Ilic");
        //ld.setItemsOrder(new ArrayList(Arrays.asList("kapucino , truska kafa, lenja pita sa jabukama")));
        listOrders = new ArrayList<Order>();
        listOrders.add(new Order(1,fmt1,9));
        listOrders.add(new Order(3,fmt2,9));
        listOrders.add(new Order(4,fmt3,9));
        ld.setOrders(listOrders);
        ld.setNumberTable(2);
        ld.setPaidOrNot(true);
        ld.setId(22);
        ld.setTime("5.5.2016. 18:30 ");
        listOfRezervations.add(ld);

        ld = new Rezervation();

        ld.setName_user("milanka rajicic");
        // ld.setItemsOrder(new ArrayList(Arrays.asList("koka kola , koka kola, lenja pita sa jabukama")));
        listOrders = new ArrayList<Order>();
        listOrders.add(new Order(1,fmt1,71));
        listOrders.add(new Order(3,fmt2,17));
        listOrders.add(new Order(4,fmt3,17));
        ld.setOrders(listOrders);
        ld.setNumberTable(2);
        ld.setId(40);
        ld.setPaidOrNot(true);
        ld.setTime("5.5.2016. 18:00");
        listOfRezervations.add(ld);


        ld = new Rezervation();
        ld.setName_user("novak stojanovic");
        //  ld.setItemsOrder(new ArrayList(Arrays.asList("jelen pivo ,crveno vino , lenja pita sa jabukama")));
        listOrders = new ArrayList<Order>();
        listOrders.add(new Order(1,fmt1,12));
        listOrders.add(new Order(3,fmt2,13));
        listOrders.add(new Order(4,fmt3,13));
        ld.setOrders(listOrders);
        ld.setNumberTable(1);
        ld.setId(7);
        ld.setPaidOrNot(true);

        ld.setTime("5.5.2016. 17:00 ");
        listOfRezervations.add(ld);
    }

    public  Boolean logIN(String mEmail, String mPassword) {
        return true;
    }

    public String UserType(){
        return "konobar";
    }
    public String NameOfUser (){
        return "Pera Peric";
    }

    public String[] stringListofTables (){
        return  listaTable;
    }

    public String[] stringListofFoodItems (){
        ArrayList<String> returnStringList = new ArrayList<String>();
        returnStringList.add("kategory");
        for(FoodMenuItem foodMenuItem : listFoodMenuItem ){
            returnStringList.add(foodMenuItem.getFood());
        }
        String[] stringList = new String[returnStringList.size()];
        stringList = returnStringList.toArray(stringList);
        return  stringList;
    }

    public ArrayList<Rezervation> getListOfRezervations(){
        return listOfRezervations;
    }

    public ArrayList<Rezervation> getRezervationsWithRegulation(SelecionRegulations selecionRegulation) {
        if(selecionRegulation.isAll()){

            return listOfRezervations;
        }

        ArrayList<Rezervation> returnRezerList = new ArrayList<>();
        for (Rezervation currRezervation : listOfRezervations){

            if(selecionRegulation.isKategory_selected()){
                for (Order currorder :currRezervation.getOrders()){
                    if(currorder.getOrder().getFood().equals(selecionRegulation.getKategory())){
                        returnRezerList.add(currRezervation);
                        break;
                    }
                }
            }

            if(selecionRegulation.isNumberOfTable_selectied()){
                if(currRezervation.getnumberTable() == selecionRegulation.getNumberOfTable()){
                    returnRezerList.add(currRezervation);
                }

            }
            if(selecionRegulation.isPaidOrNot_selected() && selecionRegulation.isPaidOrNot()){
                //ubaci sve koji su placeni
                if(currRezervation.isPaidOrNot() == true ){
                    returnRezerList.add(currRezervation);
                }
            }
        }
        return returnRezerList;

    }
}
