package com.example.marijaradisavljevic.restoran.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.marijaradisavljevic.restoran.R;
import com.example.marijaradisavljevic.restoran.adapters.ListData;
import com.example.marijaradisavljevic.restoran.adapters.MyCustomAdatperForTheList;

import java.util.ArrayList;

/**
 * Created by marija.radisavljevic on 5/13/2016.
 */
public class FragmentListReservations extends Fragment {

    //i get list of reservatins from back end
    ListView lvDetail;
    Context context ;
    ArrayList<ListData> myList = new ArrayList<ListData>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        context = getActivity();


        setHasOptionsMenu(true);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mRoot = inflater.inflate(R.layout.list_rezervations, container, false);
        context = getActivity();
        lvDetail = (ListView)mRoot.findViewById(R.id.list_reservations);
        getDataInList();
        MyCustomAdatperForTheList<ListData> adapter = new MyCustomAdatperForTheList(context,myList);

        // TODO: 5/13/2016 add new MyCustomAdatperForTheList adapter and populate listReservations

        lvDetail.setAdapter(adapter);

        return mRoot;
    }


    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_logout).setVisible(true);
        menu.findItem(R.id.action_user_info).setVisible(true);
        menu.findItem(R.id.action_add).setVisible(true);
        super.onPrepareOptionsMenu(menu);
    }


    //TODO 5/19/2016  this  is read from DB
    private void getDataInList() {





       /* ListData ld = new ListData();
        ld.setName_user("milica jelic");
        ld.setItemsOrder("kapucino , truska kafa, lenja pita sa jabukama");
        ld.setNumberTable("3");
        ld.setPaidOrNot("paid");
        ld.setPrice("540 rsd");
        ld.setTime("5.5.2016. 17:30 ");
        myList.add(ld);
         ld = new ListData();
        ld.setName_user("milanka rajicic");
        ld.setItemsOrder("koka kola , koka kola, lenja pita sa jabukama");
        ld.setNumberTable("2");
        ld.setPaidOrNot("paid");
        ld.setPrice("350 rsd");
        ld.setTime("5.5.2016. 18:00");
        myList.add(ld);
         ld = new ListData();
        ld.setName_user("novak stojanovic");
        ld.setItemsOrder("jelen pivo ,crveno vino , lenja pita sa jabukama");
        ld.setNumberTable("1");
        ld.setPaidOrNot("paid");
        ld.setPrice("690 rsd");
        ld.setTime("5.5.2016. 17:00 ");
        myList.add(ld);*/



    }

}
