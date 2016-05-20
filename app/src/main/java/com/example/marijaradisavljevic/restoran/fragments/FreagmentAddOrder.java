package com.example.marijaradisavljevic.restoran.fragments;

import android.content.Context;
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
import com.example.marijaradisavljevic.restoran.adapters.HolderAdapterItem;
import com.example.marijaradisavljevic.restoran.adapters.MyCustomAdatperForTheList;
import com.example.marijaradisavljevic.restoran.database.AdapterDB;

import com.example.marijaradisavljevic.restoran.database.Rezervation;
import com.example.marijaradisavljevic.restoran.spiner.spinnerAdapter;

import java.util.Date;

/**
 * Created by marija.radisavljevic on 5/13/2016.
 */
public class FreagmentAddOrder extends Fragment implements View.OnClickListener {

    private  Button split_order,new_item,make_order;
    private CheckedTextView paidOrNot;
    private static FreagmentAddOrder instance;

    private Rezervation rezervation;
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


        Bundle bundle =  this.getArguments();
        String action = bundle.getString("action");

        if (action.equals("onclick")){

            String rezervationIdString = getArguments().getString("rezervationId");
            int rezeravtionid = Integer.parseInt(rezervationIdString);
            rezervation = AdapterDB.getInstance().getClickActionRezervation(rezeravtionid);

            TextView time = (TextView)mRoot.findViewById(R.id.time);
            time.setText(rezervation.gettime());//
        }else{
            if (action.equals("plusbutton")){
                rezervation = AdapterDB.getInstance().getNewRezervation();

                TextView time = (TextView)mRoot.findViewById(R.id.time);
                Date date = new Date();
                rezervation.setTime(date.toString());
                time.setText(date.toString());//
            }else{
                //TODO
            }
        }


       //buttons
        split_order = (Button) mRoot.findViewById(R.id.split_order);
        split_order.setOnClickListener(this);
        make_order = (Button) mRoot.findViewById(R.id.make_order);
        make_order.setOnClickListener(this);
        new_item  = (Button) mRoot.findViewById(R.id.new_item);
        new_item.setOnClickListener(this);


        paidOrNot  = (CheckedTextView) mRoot.findViewById(R.id.paidOrNot);
        paidOrNot.setChecked(rezervation.ispaidOrNot());
        paidOrNot.setOnClickListener(this);

        Spinner numbreOfTable_spinner = (Spinner)  mRoot.findViewById(R.id.numbreOfTable_spinner);
        String[] value = getResources().getStringArray(R.array.numbers);
        ArrayAdapter<String> adapter_number_of_table = new spinnerAdapter(getActivity(),android.R.layout.simple_spinner_item,value);
        // Specify the layout to use when the list of choices appears
        adapter_number_of_table.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        numbreOfTable_spinner.setAdapter(adapter_number_of_table);
        numbreOfTable_spinner.setSelection(rezervation.getnumberTable());//


        ListView listaAddOrder = (ListView) mRoot.findViewById(R.id.listaAddOrder);

        MyCustomAdatperForTheList<ItemOrder> adapter = new MyCustomAdatperForTheList(getActivity());

        for (int i=0 ; i<rezervation.getitemsOrder().size();i++) {
            adapter.addItem(new ItemOrder(rezervation.getitemsOrder().get(i)));//

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
                    //TODO
                break;
            case R.id.make_order:
                //TODO
                break;
            case R.id.new_item:
                //TODO
                break;
            case R.id.paidOrNot:
                rezervation.setPaidOrNot(paidOrNot.isChecked());
                break;
        }

    }
    public class ItemOrder extends HolderAdapterItem {

        private String itemorder;


        public ItemOrder(String itemorder){
            this.itemorder = itemorder;


        }
        @Override
        public boolean isEnabled() {//cemu sluzi
            return true;
        }

        @Override
        public View getView(Context context, View convertView, ViewGroup parent) {
            return super.getView(context, convertView, parent);
        }

        @Override
        protected int getViewLayoutResId() {
            return R.layout.item_order;
        }

        @Override
        protected  IViewHolder createViewHolder() {
            return  new OrderViewHolder();
        }

        private class  OrderViewHolder implements IViewHolder<ItemOrder> {
            TextView  itemOrder;
            Button  remove;
            CheckedTextView innewRezervations;


            @Override
            public void findViews(View convertView) {
                itemOrder =(TextView) convertView.findViewById(R.id.item_order);
                remove = (Button)convertView.findViewById(R.id.remove);
                innewRezervations =(CheckedTextView) convertView.findViewById(R.id.in_new_order);

            }
            @Override
            public void fillData(final ItemOrder adapterItem) {

                itemOrder.setVisibility(View.VISIBLE);
                itemOrder.setText(adapterItem.itemorder);
                remove.setVisibility(View.VISIBLE);

                innewRezervations.setVisibility(View.VISIBLE);
                innewRezervations.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                remove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });



            }
        }
    }

}
