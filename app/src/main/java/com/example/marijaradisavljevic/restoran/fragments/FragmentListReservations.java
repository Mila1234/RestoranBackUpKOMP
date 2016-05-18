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

    public FragmentListReservations() {
        context = getActivity();
    }

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
        getDataInList();
        MyCustomAdatperForTheList adapter = new MyCustomAdatperForTheList(context,myList);

        // TODO: 5/13/2016 add new MyCustomAdatperForTheList adapter and populate listReservations

        lvDetail.setAdapter(adapter);

        return mRoot;
    }

    private void getDataInList() {

    }
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_logout).setVisible(true);
        menu.findItem(R.id.action_user_info).setVisible(true);
        menu.findItem(R.id.action_add).setVisible(true);
        super.onPrepareOptionsMenu(menu);
    }


}
