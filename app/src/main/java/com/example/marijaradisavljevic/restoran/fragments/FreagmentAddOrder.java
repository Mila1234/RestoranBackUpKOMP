package com.example.marijaradisavljevic.restoran.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.example.marijaradisavljevic.restoran.R;

/**
 * Created by marija.radisavljevic on 5/13/2016.
 */
public class FreagmentAddOrder extends Fragment{
private static FreagmentAddOrder instance;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mRoot = inflater.inflate(R.layout.order,container,false);

        return mRoot;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_logout).setVisible(false);
        menu.findItem(R.id.action_user_info).setVisible(false);
        menu.findItem(R.id.action_add).setVisible(false);
        super.onPrepareOptionsMenu(menu);
    }

    public static FreagmentAddOrder getInstance() {
        if(instance == null){
            return new FreagmentAddOrder();
        }else return instance;
    }
}
