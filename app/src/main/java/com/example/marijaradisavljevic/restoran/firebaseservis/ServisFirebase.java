package com.example.marijaradisavljevic.restoran.firebaseservis;

import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.marijaradisavljevic.restoran.R;
import com.example.marijaradisavljevic.restoran.activiry.ActivityFirst;
import com.example.marijaradisavljevic.restoran.activiry.LoginActivity;
import com.example.marijaradisavljevic.restoran.activiry.SignUpActivity;
import com.example.marijaradisavljevic.restoran.database.FoodMenuItem;
import com.example.marijaradisavljevic.restoran.database.Order;
import com.example.marijaradisavljevic.restoran.database.Rezervation;
import com.example.marijaradisavljevic.restoran.database.SelecionRegulations;
import com.example.marijaradisavljevic.restoran.database.UserInfo;
import com.example.marijaradisavljevic.restoran.fragments.FreagmentAddOrder;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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


    public void createUser(String email, String password) {


    }


    public void logIN(String email, String password) {




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

}
