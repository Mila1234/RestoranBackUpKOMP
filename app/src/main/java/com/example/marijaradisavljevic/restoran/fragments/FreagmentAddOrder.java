package com.example.marijaradisavljevic.restoran.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.marijaradisavljevic.restoran.R;
import com.example.marijaradisavljevic.restoran.activiry.ActivityFirst;
import com.example.marijaradisavljevic.restoran.adapters.MyCustomAdatperForTheList;
import com.example.marijaradisavljevic.restoran.spiner.spinnerAdapter;

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
       // ((ActivityFirst)getActivity()). getSupportActionBar().show();


        Button split_order = (Button) mRoot.findViewById(R.id.split_order);
        time
                make_order
        new_item
                paidOrNot
        Spinner numbreOfTable_spinner = (Spinner)  mRoot.findViewById(R.id.numbreOfTable_spinner);



        String[] value = getResources().getStringArray(R.array.numbers);
        ArrayAdapter<String> adapter_number_of_table = new spinnerAdapter(getActivity(),
                android.R.layout.simple_spinner_item,value);
        // Specify the layout to use when the list of choices appears
        adapter_number_of_table.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        numbreOfTable_spinner.setAdapter(adapter_number_of_table);
        numbreOfTable_spinner.setSelection(adapter_number_of_table.getCount());


        ListView listaAddOrder =
        MyCustomAdatperForTheList adapter = new MyCustomAdatperForTheList<ItemOrder>()
        listaAddOrder.add(adapter);
        return mRoot;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_logout).setVisible(false);
        menu.findItem(R.id.action_user_info).setVisible(false);
        menu.findItem(R.id.action_add).setVisible(true);
        super.onPrepareOptionsMenu(menu);
    }

    public static FreagmentAddOrder getInstance() {
        if(instance == null){
            return new FreagmentAddOrder();
        }else return instance;
    }


}
