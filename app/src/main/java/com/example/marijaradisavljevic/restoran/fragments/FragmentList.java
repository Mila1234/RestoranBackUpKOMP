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
import com.example.marijaradisavljevic.restoran.adapters.MyCustomAdatperForTheList;

/**
 * Created by marija.radisavljevic on 5/13/2016.
 */
public class FragmentList extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mRoot = inflater.inflate(R.layout.the_list, container, false);

        ListView the_list = (ListView)mRoot.findViewById(R.id.the_list);

        MyCustomAdatperForTheList adapter = new MyCustomAdatperForTheList();

        // TODO: 5/13/2016 add new MyCustomAdatperForTheList adapter and populate the_list

        the_list.setAdapter(adapter);

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
