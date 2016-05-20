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
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.marijaradisavljevic.restoran.R;
import com.example.marijaradisavljevic.restoran.adapters.ItemOrder;
import com.example.marijaradisavljevic.restoran.adapters.MyCustomAdatperForTheList;
import com.example.marijaradisavljevic.restoran.database.AdapterDB;

import com.example.marijaradisavljevic.restoran.database.Order;
import com.example.marijaradisavljevic.restoran.spiner.spinnerAdapter;

/**
 * Created by marija.radisavljevic on 5/13/2016.
 */
public class FreagmentAddOrder extends Fragment implements View.OnClickListener {


    private static FreagmentAddOrder instance;


    //TODO private ArrayList<String> whatAction;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mRoot = inflater.inflate(R.layout.order,container,false);

        Order order;
       // order = AdapterDB.getInstance().getNewOrder();
        order = AdapterDB.getInstance().getClickActionRezervation();
        //TODO order in new Order if iz action is on plus button but it is order from database if
        // TODO it is aciton click on rezervation on list of rezervation


        TextView time = (TextView)mRoot.findViewById(R.id.time);
        time.setText(order.getTime());//

        Button split_order = (Button) mRoot.findViewById(R.id.split_order);
        split_order.setOnClickListener(this);
        Button make_order = (Button) mRoot.findViewById(R.id.make_order);
        make_order.setOnClickListener(this);
        Button new_item  = (Button) mRoot.findViewById(R.id.new_item);
        new_item.setOnClickListener(this);

        CheckedTextView paidOrNot  = (CheckedTextView) mRoot.findViewById(R.id.paidOrNot);
        paidOrNot.setChecked(order.isPaidOrNot());

        Spinner numbreOfTable_spinner = (Spinner)  mRoot.findViewById(R.id.numbreOfTable_spinner);
        String[] value = getResources().getStringArray(R.array.numbers);
        ArrayAdapter<String> adapter_number_of_table = new spinnerAdapter(getActivity(),android.R.layout.simple_spinner_item,value);
        // Specify the layout to use when the list of choices appears
        adapter_number_of_table.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        numbreOfTable_spinner.setAdapter(adapter_number_of_table);
        numbreOfTable_spinner.setSelection(order.getNumbreOfTable_spinner());//


        ListView listaAddOrder = (ListView) mRoot.findViewById(R.id.listaAddOrder);

        MyCustomAdatperForTheList<ItemOrder> adapter = new MyCustomAdatperForTheList(getActivity());

        for (int i=0 ; i<order.getListOrder().size();i++) {
            adapter.addItem(new ItemOrder(order.getListOrder().get(i)));//

        }
        listaAddOrder.setAdapter(adapter);
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


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.split_order:
                break;
            case R.id.make_order:
                break;
            case R.id.new_item:
                break;

        }

    }


}
