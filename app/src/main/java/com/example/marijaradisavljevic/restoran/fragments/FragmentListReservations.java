package com.example.marijaradisavljevic.restoran.fragments;

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
import com.example.marijaradisavljevic.restoran.adapters.ItemForRezervationsList;
import com.example.marijaradisavljevic.restoran.database.Rezervation;
import com.example.marijaradisavljevic.restoran.adapters.MyCustomAdatperForTheList;
import com.example.marijaradisavljevic.restoran.database.AdapterDB;

import java.util.ArrayList;

/**
 * Created by marija.radisavljevic on 5/13/2016.
 */
public class FragmentListReservations extends Fragment {


    ListView lvDetail;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mRoot = inflater.inflate(R.layout.list_rezervations, container, false);

        lvDetail = (ListView)mRoot.findViewById(R.id.list_reservations);

        MyCustomAdatperForTheList<ItemForRezervationsList> adapter = new MyCustomAdatperForTheList(getActivity());
        ArrayList<Rezervation> myList = AdapterDB.getInstance().getRezervations();
        adapter.addItem(new ItemForRezervationsList(myList.get(0)));
        adapter.addItem(new ItemForRezervationsList(myList.get(1)));
        adapter.addItem(new ItemForRezervationsList(myList.get(2)));

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





}
