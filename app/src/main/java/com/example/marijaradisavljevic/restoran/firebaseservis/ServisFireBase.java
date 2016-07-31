package com.example.marijaradisavljevic.restoran.firebaseservis;



import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.marijaradisavljevic.restoran.activiryadmin.ActivityMainList;
import com.example.marijaradisavljevic.restoran.activiryuser.ActivityGUI;
import com.example.marijaradisavljevic.restoran.activity.BaseActivity;
import com.example.marijaradisavljevic.restoran.database.FoodMenuItem;
import com.example.marijaradisavljevic.restoran.database.Order;
import com.example.marijaradisavljevic.restoran.database.Rezervation;
import com.example.marijaradisavljevic.restoran.database.SelecionRegulations;
import com.example.marijaradisavljevic.restoran.database.UserInfo;
import com.example.marijaradisavljevic.restoran.fragments.FreagmentAddOrder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * Created by marija.radisavljevic on 6/3/2016.
 */
public class ServisFireBase extends BaseActivity{

    private static final String TAG = "ServisFireBase";

    private static ServisFireBase instance = new ServisFireBase();
    public static ServisFireBase getInstance() {

        instance.startActivity(new Intent());

        return instance; }


    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    // [END declare_database_ref]

    String[] listUsersTypes;
    private String[] listaTable;
    private String[] numberItemssStrignList;


    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

    public ServisFireBase() {

        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END initialize_database_ref]


        listUsersTypes = new String[2];
        listUsersTypes[0]= "konobar";
        listUsersTypes[1]= "admin";

        numberItemssStrignList = new String[7];
        numberItemssStrignList[0] = "1";
        numberItemssStrignList[1] ="2" ;
        numberItemssStrignList[2] ="3";
        numberItemssStrignList[3] ="4";
        numberItemssStrignList[4] ="5";
        numberItemssStrignList[5] = "6";
        numberItemssStrignList[6] = "broj komada";

        listaTable = new String[6];
        listaTable[0] = "1";
        listaTable[1] ="2" ;
        listaTable[2] ="3";
        listaTable[3] ="4";
        listaTable[4] ="5";
        listaTable[5] = "broj stola";






    }

    public String toolBarTypeNameSurnameString(){
        String bla = "";

        // [START single_value_read]
        final String userId = getUid();//current user
        mDatabase.child("users").child(userId).addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        UserInfo user = dataSnapshot.getValue(UserInfo.class);

                        // [START_EXCLUDE]
                        if (user == null) {
                            // User is null, error out
                            Log.e(TAG, "User " + userId + " is unexpectedly null");
                            Toast.makeText(getApplicationContext() ,
                                    "Error: could not fetch user.",
                                    Toast.LENGTH_SHORT).show();
                        } else {

                             bla = user.getType()+" : "+user.getName()+" "+user.getSurname();

                        }


                        // [END_EXCLUDE]
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                    }
                });
        // [END single_value_read]





        return bla;
    }

    public  Boolean logIN(String username, String password) {

        Boolean value = false;

        return value;

    }

    public UserInfo getUserInfofromList(String uid){
        UserInfo ui = new UserInfo();


        // [START single_value_read]
        final String userId = getUid();//current user
        mDatabase.child("users").child(uid).addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        UserInfo user = dataSnapshot.getValue(UserInfo.class);

                        // [START_EXCLUDE]
                        if (user == null) {
                            // User is null, error out
                            Log.e(TAG, "User " + userId + " is unexpectedly null");
                            Toast.makeText(getApplicationContext() ,
                                    "Error: could not fetch user.",
                                    Toast.LENGTH_SHORT).show();
                        } else {

                            ui = user;

                        }


                        // [END_EXCLUDE]
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                    }
                });
        // [END single_value_read]



        return ui;
    }

    public UserInfo getUserInfo() {


        UserInfo ui = new UserInfo();


        // [START single_value_read]
        final String userId = getUid();//current user
        mDatabase.child("users").child(userId).addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        UserInfo user = dataSnapshot.getValue(UserInfo.class);

                        // [START_EXCLUDE]
                        if (user == null) {
                            // User is null, error out
                            Log.e(TAG, "User " + userId + " is unexpectedly null");
                            Toast.makeText(getApplicationContext() ,
                                    "Error: could not fetch user.",
                                    Toast.LENGTH_SHORT).show();
                        } else {

                            ui = user;

                        }


                        // [END_EXCLUDE]
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                    }
                });
        // [END single_value_read]



        return ui;




    }



    public void setUserInfo(UserInfo ui){
//napravi usera u tabeli users
       // UserInfo user = new UserInfo( email);
        mDatabase.child("users").child(ui.getUid()).setValue(ui);

           // for(UserInfo rez: listUsers){
                //if already exists indatabase update it
                //if(rez.getUsername().equals(ui.getUsername()) && rez.getPassword().equals(ui.getPassword())){
                   // listUsers.remove(rez);
                   // listUsers.add(ui);
                   // break;
                //}
            }
         //   userInfo = ui;


    }


    public String[] stringListofFoodItems (){
        ArrayList<String> returnStringList = new ArrayList<String>();
        String[] stringList = null;




            for(FoodMenuItem foodMenuItem : listFoodMenuItem ){
                returnStringList.add(foodMenuItem.getFood());
            }
            returnStringList.add("kategory");
            stringList = new String[returnStringList.size()];
            stringList = returnStringList.toArray(stringList);

        // [START single_value_read]
        final String userId = getUid();//current user
        mDatabase.child("users").child(userId).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        UserInfo user = dataSnapshot.getValue(UserInfo.class);

                        // [START_EXCLUDE]
                        if (user == null) {
                            // User is null, error out
                            Log.e(TAG, "User " + userId + " is unexpectedly null");
                            Toast.makeText(getApplicationContext(),
                                    "Error: could not fetch user.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            //zavisno od ulogovanog usera ide se na restoran ili restoran admin
                            Intent intent;
                            switch (user.getType() ){
                                case "admin":
                                    intent = new Intent(getApplicationContext(), ActivityMainList.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    getApplicationContext().startActivity(intent);

                                    break;
                                case "user":
                                    intent = new Intent(getApplicationContext(), ActivityGUI.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    getApplicationContext().startActivity(intent);
                                    break;
                            }



                        }

                        // Finish this Activity, back to the stream
                        finish();
                        // [END_EXCLUDE]
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                    }
                });
        // [END single_value_read]

        return  stringList;
    }


    public String[] stringListofTables (){
        return  listaTable;
    }





    public ArrayList<Rezervation> getRezervationsWithRegulation(SelecionRegulations selecionRegulation) {
        if(selecionRegulation.isAll()){

            return listOfRezervations;
        }

        ArrayList<Rezervation> returnRezerList = new ArrayList<>();


        try{
                mutex.acquire();

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



    public String newRezervation (){
        Integer i=-1;
            try{
                mutex.acquire();

        Rezervation r = new Rezervation();
        listOfRezervations.add(r);
        i = r.getId();


            } catch (Exception e) {
                e.printStackTrace();

            }finally{
                mutex.release();
            }
        return String.valueOf(i);
    }

    public void AddRezervation(String id, String time,String nuberTable, boolean ispaidnOrnot,ArrayList<FreagmentAddOrder.ItemOrder> listaOrder ){
            try{
                mutex.acquire();
                    for(Rezervation rez: listOfRezervations){
                        if(rez.getId()== Integer.parseInt(id)){
                            //update info

                          //  rez.setPassword(userInfo.getPassword());
                            rez.setUsername(userInfo.getUsername());
                            rez.setTime(time);
                            rez.setPaidOrNot(ispaidnOrnot);
                            rez.setNumberTable(Integer.parseInt(nuberTable));
                            ArrayList<Order> lista = new ArrayList<Order>();
                            for(FreagmentAddOrder.ItemOrder curOrder : listaOrder){
                                lista.add(curOrder.getOrder());
                            }
                            rez.setOrders(lista);

                        }

                    }

            } catch (Exception e) {
                e.printStackTrace();

            }finally{
                mutex.release();
            }


    }

    public void addOrder(int id, String numberOfItems, String Kategory) {
            try{
                mutex.acquire();
                    for(Rezervation rez: listOfRezervations){
                        if(rez.getId()== id){

                          /*  boolean find = null;
                            for(Order curOrd: rez.getOrders()){
                                if(curOrd.getOrder().getFood().equals(Kategory)){
                                    curOrd.setNuberOrder(curOrd.getNuberOrder()+numberOfItems);
                                    find = true;
                                    break;

                                }
                            }*/
                           // if (find==null) {
                                Order ord = new Order();

                                ord.setNuberOrder(Integer.parseInt(numberOfItems));
                                for (FoodMenuItem fmi : listFoodMenuItem) {
                                    if (fmi.getFood().equals(Kategory)) {
                                        ord.setOrder(fmi);
                                        break;
                                    }

                                }
                                rez.getOrders().add(ord);
                            //}

                        }

                    }

            } catch (Exception e) {
                e.printStackTrace();

            }finally{
                mutex.release();
            }
    }

    private FoodMenuItem getGoodmenuItem(String kategory) {
        FoodMenuItem value = null;

            try{
                mutex.acquire();

        for(FoodMenuItem f:listFoodMenuItem){
            if (f.getFood().equals(kategory)){
                value =   f;
            }
        }


            } catch (Exception e) {
                e.printStackTrace();

            }finally{
                mutex.release();
            }

    return value;
    }

    public String getTimeForRezervation(String rezervationIdString) {
        String value = "";

            try{
                mutex.acquire();

        for(Rezervation rez: listOfRezervations){
            if(rez.getId() == Integer.parseInt(rezervationIdString)){

                value = rez.gettime();
            }

        }


            } catch (Exception e) {
                e.printStackTrace();

            }finally{
                mutex.release();
            }

        return value;
    }

    public boolean getPaidOrNot(String rezervationIdString) {
        boolean value = false;

            try{
                mutex.acquire();

        for(Rezervation rez: listOfRezervations){
            if(rez.getId() == Integer.parseInt(rezervationIdString)){

                value =  rez.isPaidOrNot();
            }

        }


            } catch (Exception e) {
                e.printStackTrace();

            }finally{
                mutex.release();
            }
             return  value;

    }

    public int getNumberOFtable(String rezervationIdString) {

    int value =-1;

            try{
                mutex.acquire();

        for(Rezervation rez: listOfRezervations){
            if(rez.getId() == Integer.parseInt(rezervationIdString)){

                value = rez.getnumberTable();
            }

        }


            } catch (Exception e) {
                e.printStackTrace();

            }finally{
                mutex.release();
            }

        return value;
    }

    public ArrayList<Order> getListOrders(String rezervationIdString) {
        ArrayList<Order> value = null;
                try{
                    mutex.acquire();

                        for(Rezervation rez: listOfRezervations){
                            if(rez.getId() == Integer.parseInt(rezervationIdString)){
                                value = rez.getOrders();
                            }

                        }

                } catch (Exception e) {
                    e.printStackTrace();

                }finally{
                    mutex.release();
                }
        return value;
    }




    public String[] getNumberItems() {
        return numberItemssStrignList;
    }

    public void removeorderForRezer(Order o,String rezervationIdString) {
                try{
                    mutex.acquire();

        for(Rezervation rez: listOfRezervations){
            if(rez.getId() == Integer.parseInt(rezervationIdString) ){
               for(Order currOrd:rez.getOrders()){
                   if(o.getId()==currOrd.getId()){
                       rez.getOrders().remove(currOrd);
                       break;
                   }
               }
            }

        }
                } catch (Exception e) {
                    e.printStackTrace();

                }finally{
                    mutex.release();
                }

    }

    public void removeRezer(int id) {
                try{
                    mutex.acquire();


                    for(Rezervation rez: listOfRezervations){
                        if(rez.getId() == id){
                            listOfRezervations.remove(rez);
                            break;
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();

                }finally{
                    mutex.release();
                }
    }

    public String[] strignListTypeOFUsers() {
        String[] bla = null ;
        try{
            mutex.acquire();


            bla = new String[3];
            bla[2] = "type of user";
            bla[1] ="konobar" ;
            bla[0] ="admin";

        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            mutex.release();
        }
        return bla;
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

    public void updateUserInfoFromList(UserInfo ui, String usernameString, String passordSrting) {
        try{
            mutex.acquire();

            for(UserInfo rez: listUsers){
               // if(rez.getUsername().equals(usernameString) && rez.getPassword().equals(passordSrting)){
                    //rez = ui;
                   // listUsers.remove(rez);
                    //break;
               // }

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
               // if(rez.getUsername().equals(username) && rez.getPassword().equals(password)){
                   // listUsers.remove(rez);
                   // break;
                //}

            }
        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            mutex.release();
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
