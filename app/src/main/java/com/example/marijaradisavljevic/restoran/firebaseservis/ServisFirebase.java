package com.example.marijaradisavljevic.restoran.firebaseservis;

import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

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
import com.example.marijaradisavljevic.restoran.servis.Servis;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 * Created by marija.radisavljevic on 7/20/2016.
 */
public class ServisFirebase   {
    private static ServisFirebase ourInstance = new ServisFirebase();

    public static ServisFirebase getInstance() {
    

        return ourInstance;
    }

private AppCompatActivity callingactivity;

    public AppCompatActivity getCallingactivity() {
        return callingactivity;
    }

    public void setCallingactivity(AppCompatActivity callingactivity) {
        this.callingactivity = callingactivity;
    }

    final Firebase ref = new Firebase(Constants.FIREBASE_URL);
    private Semaphore mutex;

    private UserInfo userInfo; //current user
    String[] listUsersTypes;
    private ArrayList<UserInfo> listUsers;
    private String[] listaTable;
    private String[] numberItemssStrignList;
    private ArrayList<FoodMenuItem> listFoodMenuItem;
    private ArrayList<Rezervation> listOfRezervations;


    public ServisFirebase() {


        mutex = new Semaphore(1);
        listUsersTypes = new String[2];
        listUsersTypes[0] = "konobar";
        listUsersTypes[1] = "admin";
        listUsers = new ArrayList<UserInfo>();


        UserInfo userInfo1 = new UserInfo();
        userInfo1.setEmail("marijarad89@gmail.com");
        userInfo1.setName("Marija");
        userInfo1.setSurname("Radisavljevic");
        userInfo1.setNumber("060123789");
        userInfo1.setUsername("marijarad89@gmail.com");
        userInfo1.setType("konobar");
        userInfo1.setPassword("sifra");

        userInfo = userInfo1;

        listUsers.add(userInfo1);
        userInfo1 = new UserInfo();
        userInfo1.setEmail("anailic@gmail.com");
        userInfo1.setName("Ana");
        userInfo1.setSurname("Ilic");
        userInfo1.setNumber("060123789");
        userInfo1.setUsername("anailic@gmail.com");
        userInfo1.setType("konobar");
        userInfo1.setPassword("sifra");
        listUsers.add(userInfo1);
        userInfo1 = new UserInfo();
        userInfo1.setEmail("paja@gmail.com");
        userInfo1.setName("Pavle");
        userInfo1.setSurname("Stojanovic");
        userInfo1.setNumber("060123789");
        userInfo1.setUsername("paja@gmail.com");
        userInfo1.setType("konobar");
        userInfo1.setPassword("sifra");
        listUsers.add(userInfo1);

        numberItemssStrignList = new String[7];
        numberItemssStrignList[0] = "1";
        numberItemssStrignList[1] = "2";
        numberItemssStrignList[2] = "3";
        numberItemssStrignList[3] = "4";
        numberItemssStrignList[4] = "5";
        numberItemssStrignList[5] = "6";
        numberItemssStrignList[6] = "broj komada";

        listaTable = new String[6];
        listaTable[0] = "1";
        listaTable[1] = "2";
        listaTable[2] = "3";
        listaTable[3] = "4";
        listaTable[4] = "5";
        listaTable[5] = "broj stola";


        listFoodMenuItem = new ArrayList<FoodMenuItem>();
        FoodMenuItem nadtavka = new FoodMenuItem(null, "pice", 100);
        listFoodMenuItem.add(nadtavka);
        FoodMenuItem fmt1 = new FoodMenuItem(nadtavka, "1 type food", 100);
        listFoodMenuItem.add(fmt1);
        FoodMenuItem fmt2 = new FoodMenuItem(nadtavka, "2 type food", 100);
        listFoodMenuItem.add(fmt2);

        FoodMenuItem fmt3 = new FoodMenuItem(nadtavka, "3 type food", 100);
        listFoodMenuItem.add(fmt3);

        FoodMenuItem fmt4 = new FoodMenuItem(nadtavka, "4 type food", 100);
        listFoodMenuItem.add(fmt4);


        listOfRezervations = new ArrayList<Rezervation>();


        Rezervation ld = new Rezervation();
        ld.setUsername("marijarad89@gmail.com");
        ld.setPassword("sifra");
        // ld.setItemsOrder(new ArrayList(Arrays.asList("kapucino , truska kafa, lenja pita sa jabukama")));
        ArrayList<Order> listOrders = new ArrayList<Order>();
        listOrders.add(new Order(1, fmt1, 1));
        listOrders.add(new Order(3, fmt2, 1));
        listOrders.add(new Order(4, fmt3, 1));

        ld.setOrders(listOrders);
        ld.setNumberTable(3);
        ld.setPaidOrNot(true);

        ld.setTime("5.5.2016. 17:30 ");
        ld.setId(555);
        listOfRezervations.add(ld);

        ld = new Rezervation();
        ld.setUsername("anailic@gmail.com");
        ld.setPassword("sifra");
        //ld.setItemsOrder(new ArrayList(Arrays.asList("kapucino , truska kafa, lenja pita sa jabukama")));
        listOrders = new ArrayList<Order>();
        listOrders.add(new Order(1, fmt1, 9));
        listOrders.add(new Order(3, fmt2, 9));
        listOrders.add(new Order(4, fmt3, 9));
        ld.setOrders(listOrders);
        ld.setNumberTable(2);
        ld.setPaidOrNot(true);
        ld.setId(22);
        ld.setTime("5.5.2016. 18:30 ");
        listOfRezervations.add(ld);


        ld = new Rezervation();

        ld.setUsername("paja@gmail.com");
        ld.setPassword("sifra");
        //  ld.setItemsOrder(new ArrayList(Arrays.asList("jelen pivo ,crveno vino , lenja pita sa jabukama")));
        listOrders = new ArrayList<Order>();
        listOrders.add(new Order(1, fmt1, 12));
        listOrders.add(new Order(3, fmt2, 13));
        listOrders.add(new Order(4, fmt3, 13));
        ld.setOrders(listOrders);
        ld.setNumberTable(1);
        ld.setId(7);
        ld.setPaidOrNot(true);

        ld.setTime("5.5.2016. 17:00 ");
        listOfRezervations.add(ld);
    }

    public String toolBarTypeNameSurnameString() {
        String bla = userInfo.getType() + " : " + userInfo.getName() + " " + userInfo.getSurname();
        return bla;
    }


    public void createUser(String email, String password) {


        password = password.trim();
        email = email.trim();

        if (password.isEmpty() || email.isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(callingactivity);
            builder.setMessage(R.string.signup_error_message)
                    .setTitle(R.string.signup_error_title)
                    .setPositiveButton(android.R.string.ok, null);
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {

            // signup
            ref.createUser(email, password, new Firebase.ResultHandler() {
                @Override
                public void onSuccess() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(callingactivity);
                    builder.setMessage(R.string.signup_success)
                            .setPositiveButton(R.string.login_button_label, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent( callingactivity,LoginActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    callingactivity.startActivity(intent);
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

                @Override
                public void onError(FirebaseError firebaseError) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(callingactivity);
                    builder.setMessage(firebaseError.getMessage())
                            .setTitle(R.string.signup_error_title)
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });
        }
    }


    public void logIN(String email, String password) {


        email = email.trim();
        password = password.trim();

        if (email.isEmpty() || password.isEmpty()) {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(callingactivity);
            builder.setMessage(R.string.login_error_message)
                    .setTitle(R.string.login_error_title)
                    .setPositiveButton(android.R.string.ok, null);
            android.app.AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            final String emailAddress = email;

            //Login with an email/password combination
            ref.authWithPassword(email, password, new Firebase.AuthResultHandler() {
                @Override
                public void onAuthenticated(AuthData authData) {
                    // Authenticated successfully with payload authData
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("email", emailAddress);
                    ref.child("users").child(authData.getUid()).updateChildren(map);

                    Intent intent = new Intent(callingactivity, ActivityFirst.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    callingactivity.startActivity(intent);
                }

                @Override
                public void onAuthenticationError(FirebaseError firebaseError) {
                    // Authenticated failed with error firebaseError
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(callingactivity);
                    builder.setMessage(firebaseError.getMessage())
                            .setTitle(R.string.login_error_title)
                            .setPositiveButton(android.R.string.ok, null);
                    android.app.AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });
        }


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
