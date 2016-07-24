package com.example.marijaradisavljevic.restoran.firebaseservis;

import com.example.marijaradisavljevic.restoran.database.FoodMenuItem;
import com.example.marijaradisavljevic.restoran.database.Order;
import com.example.marijaradisavljevic.restoran.database.Rezervation;
import com.example.marijaradisavljevic.restoran.database.SelecionRegulations;
import com.example.marijaradisavljevic.restoran.database.UserInfo;
import com.example.marijaradisavljevic.restoran.fragments.FreagmentAddOrder;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import java.util.concurrent.Semaphore;

/**
 * Created by marija.radisavljevic on 7/20/2016.
 */
public class ServisFirebase   {
    private static ServisFirebase ourInstance = new ServisFirebase();

    public static ServisFirebase getInstance() {
        return ourInstance;
    }


    private FirebaseAuth mAuth;

    private Semaphore mutex;

    private UserInfo userInfo; //current user
    String[] listUsersTypes;
    private ArrayList<UserInfo> listUsers;
    private String[] listaTable;
    private String[] numberItemssStrignList;
    private ArrayList<FoodMenuItem> listFoodMenuItem;
    private ArrayList<Rezervation> listOfRezervations;


    public ServisFirebase() {





    }


    public String toolBarTypeNameSurnameString() {
        String bla = userInfo.getType() + " : " + userInfo.getName() + " " + userInfo.getSurname();
        return bla;
    }




    public UserInfo getUserInfofromList(String username, String password) {
        UserInfo ui = new UserInfo();
        try {
            mutex.acquire();
            for (UserInfo rez : listUsers) {
                if (rez.getUsername().equals(username) && rez.getPassword().equals(password)) {
                    ui = rez;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            mutex.release();
        }
        return ui;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }


    public void setUserInfo(UserInfo ui) {
        try {
            mutex.acquire();

            for (UserInfo rez : listUsers) {
                //if already exists indatabase update it
                if (rez.getUsername().equals(ui.getUsername()) && rez.getPassword().equals(ui.getPassword())) {
                    listUsers.remove(rez);
                    listUsers.add(ui);
                    break;
                }
            }
            userInfo = ui;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            mutex.release();
        }
    }


    public String[] stringListofFoodItems() {
        ArrayList<String> returnStringList = new ArrayList<String>();
        String[] stringList = null;
        try {
            mutex.acquire();


            for (FoodMenuItem foodMenuItem : listFoodMenuItem) {
                returnStringList.add(foodMenuItem.getFood());
            }
            returnStringList.add("kategory");
            stringList = new String[returnStringList.size()];
            stringList = returnStringList.toArray(stringList);


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            mutex.release();
        }
        return stringList;
    }


    public String[] stringListofTables() {
        return listaTable;
    }


    public ArrayList<Rezervation> getRezervationsWithRegulation(SelecionRegulations selecionRegulation) {
        if (selecionRegulation.isAll()) {

            return listOfRezervations;
        }

        ArrayList<Rezervation> returnRezerList = new ArrayList<>();


        try {
            mutex.acquire();

            for (Rezervation currRezervation : listOfRezervations) {

                if (selecionRegulation.isKategory_selected()) {
                    for (Order currorder : currRezervation.getOrders()) {
                        if (currorder.getOrder().getFood().equals(selecionRegulation.getKategory())) {
                            returnRezerList.add(currRezervation);
                            break;
                        }
                    }
                }

                if (selecionRegulation.isNumberOfTable_selectied()) {
                    if (currRezervation.getnumberTable().toString().equals(selecionRegulation.getNumberOfTable())) {
                        returnRezerList.add(currRezervation);
                    }

                }
                if (selecionRegulation.isPaidOrNot_selected() && selecionRegulation.isPaidOrNot()) {
                    //ubaci sve koji su placeni
                    if (currRezervation.isPaidOrNot() == true) {
                        returnRezerList.add(currRezervation);
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            mutex.release();
        }

        return returnRezerList;

    }


    public String newRezervation() {
        Integer i = -1;
        try {
            mutex.acquire();

            Rezervation r = new Rezervation();
            listOfRezervations.add(r);
            i = r.getId();


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            mutex.release();
        }
        return String.valueOf(i);
    }

    public void AddRezervation(String id, String time, String nuberTable, boolean ispaidnOrnot, ArrayList<FreagmentAddOrder.ItemOrder> listaOrder) {
        try {
            mutex.acquire();
            for (Rezervation rez : listOfRezervations) {
                if (rez.getId() == Integer.parseInt(id)) {
                    //update info

                    rez.setPassword(userInfo.getPassword());
                    rez.setUsername(userInfo.getUsername());
                    rez.setTime(time);
                    rez.setPaidOrNot(ispaidnOrnot);
                    rez.setNumberTable(Integer.parseInt(nuberTable));
                    ArrayList<Order> lista = new ArrayList<Order>();
                    for (FreagmentAddOrder.ItemOrder curOrder : listaOrder) {
                        lista.add(curOrder.getOrder());
                    }
                    rez.setOrders(lista);

                }

            }

        } catch (Exception e) {


        }

    }


    public FoodMenuItem getFootMenuItem(String foodItemId) {
        FoodMenuItem value = null;
        try{
            mutex.acquire();
            for(FoodMenuItem fmi : listFoodMenuItem){
                if (fmi.getId()==Integer.parseInt(foodItemId)){
                    value =  fmi;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            mutex.release();
        }

        return value;

    }

    public void updateFoodMenuItem(String foodItemId, String kategoryString, String nameString, String priceString) {

        for(FoodMenuItem fmi:listFoodMenuItem){
            if (fmi.getId()==Integer.parseInt(foodItemId)){
                for(FoodMenuItem nadstavkatek:listFoodMenuItem){
                    if(nadstavkatek.getFood().equals(kategoryString)){
                        fmi.setNadstavka(nadstavkatek);
                        break;
                    }

                }
                fmi.setFood(nameString);
                fmi.setPrice(Integer.parseInt(priceString));
            }

        }
    }

    public void updateUserInfoFromList(UserInfo ui, String usernameString, String passordSrting) {
        try{
            mutex.acquire();

            for(UserInfo rez: listUsers){
                if(rez.getUsername().equals(usernameString) && rez.getPassword().equals(passordSrting)){
                    //rez = ui;
                    listUsers.remove(rez);
                    break;
                }

            }
            listUsers.add(ui);
        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            mutex.release();
        }
    }
    public ArrayList<UserInfo> getUserList() {
        return listUsers;
    }

    public void removeUser(String username, String password) {
        try{
            mutex.acquire();
            for(UserInfo rez: listUsers){
                if(rez.getUsername().equals(username) && rez.getPassword().equals(password)){
                    listUsers.remove(rez);
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            mutex.release();
        }
    }

    public String[] stringlistUserNames() {
        ArrayList<String> returnStringList = new ArrayList<String>();
        String[] stringList = null;
        try{
            mutex.acquire();

            returnStringList = new ArrayList<String>();

            for(UserInfo ui: listUsers){
                returnStringList.add(ui.getUsername());
            }
            returnStringList.add("users");
            stringList = new String[returnStringList.size()];
            stringList = returnStringList.toArray(stringList);


        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            mutex.release();
        }

        return  stringList;
    }


    public ArrayList<Rezervation> getRezervationsWithRegulationForAdmin(SelecionRegulations selecionRegulation) {


        if (selecionRegulation.somethingSelectedadminListRezervations()==false){
            return  listOfRezervations;
        }

        ArrayList<Rezervation> returnRezerList = new ArrayList<>();
        try{
            mutex.acquire();


            for (Rezervation currRezervation : listOfRezervations){

                if (selecionRegulation.isUser_selected()){
                    if (currRezervation.getUsername().equals(selecionRegulation.getUser())){
                        returnRezerList.add(currRezervation);
                    }
                }

                if(selecionRegulation.isKategory_selected()){
                    for (Order currorder :currRezervation.getOrders()){
                        if(currorder.getOrder().getFood().equals(selecionRegulation.getKategory())){
                            returnRezerList.add(currRezervation);
                            break;
                        }
                    }
                }

                if(selecionRegulation.isNumberOfTable_selectied()){
                    if(currRezervation.getnumberTable().toString().equals(selecionRegulation.getNumberOfTable())  ){
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



        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            mutex.release();
        }
        return returnRezerList;

    }

    public ArrayList<FoodMenuItem> getfoodmenuitemslist() {
        return listFoodMenuItem;
    }

    public void removeFootMenuItem(int id) {
        try{
            mutex.acquire();

            for(FoodMenuItem fmi:listFoodMenuItem){
                if (fmi.getId()==id){
                    listFoodMenuItem.remove(fmi);
                    break;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            mutex.release();
        }
    }

    public void makeuserinfoIntoList(UserInfo ui) {
        try{
            mutex.acquire();

            listUsers.add(ui);
        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            mutex.release();
        }

    }
    public void makeNewFoodItem(String kategoryString, String nameString, String priceString) {
        try{
            mutex.acquire();

            FoodMenuItem nadstavka = null;
            FoodMenuItem newItem;
            for(FoodMenuItem currFMI : listFoodMenuItem){
                if(currFMI.getFood().equals(kategoryString)){
                    nadstavka = currFMI;
                    break;
                }
            }

            newItem = new FoodMenuItem( nadstavka,  nameString,  Integer.parseInt(priceString));
            listFoodMenuItem.add(newItem);

        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            mutex.release();
        }
    }

}
