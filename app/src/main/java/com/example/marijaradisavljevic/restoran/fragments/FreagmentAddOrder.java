package com.example.marijaradisavljevic.restoran.fragments;

import android.content.Context;
import android.content.Intent;
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
import com.example.marijaradisavljevic.restoran.activiry.ActivityGUI;
import com.example.marijaradisavljevic.restoran.adapters.HolderAdapterItem;
import com.example.marijaradisavljevic.restoran.adapters.MyCustomAdatperForTheList;
import com.example.marijaradisavljevic.restoran.database.AdapterDB;

import com.example.marijaradisavljevic.restoran.database.Order;
import com.example.marijaradisavljevic.restoran.database.Rezervation;
import com.example.marijaradisavljevic.restoran.spiner.MySpinnerAdapter;

import java.util.Date;

/**
 * Created by marija.radisavljevic on 5/13/2016.
 */
public class FreagmentAddOrder extends Fragment implements View.OnClickListener {

    private Button split_order,new_item,make_order;
    private CheckedTextView paidOrNot;
    private static FreagmentAddOrder instance;

    private ListView listaAddOrder;

    private Rezervation rezervation;

    private Rezervation newRezervation;
    //TODO private ArrayList<String> whatAction;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mRoot = inflater.inflate(R.layout.fragment_add_order_layout,container,false);


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
        ArrayAdapter<String> adapter_number_of_table = new MySpinnerAdapter(getActivity(),android.R.layout.simple_spinner_item,value);
        // Specify the layout to use when the list of choices appears
        adapter_number_of_table.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        numbreOfTable_spinner.setAdapter(adapter_number_of_table);
        if (action.equals("onclick")){
            numbreOfTable_spinner.setSelection(rezervation.getnumberTable());//
        }else{
            numbreOfTable_spinner.setSelection(adapter_number_of_table.getCount());//
        }



        listaAddOrder = (ListView) mRoot.findViewById(R.id.listaAddOrder);

        MyCustomAdatperForTheList<ItemOrder> adapter = new MyCustomAdatperForTheList(getActivity());
        try{
            for (int i=0 ; i<rezervation.getOrders().size();i++) {
                Order order = rezervation.getOrders().get(i);
                Order clone = order.clone();
                adapter.addItem(new ItemOrder(clone));

            }

        }catch (Exception e){
            System.out.print(e.getStackTrace());
        }
        listaAddOrder.setAdapter(adapter);
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


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.split_order:


                    //TODO
                break;
            case R.id.make_order: //TODO make, remake order !
                AdapterDB.getInstance().putRezervation(rezervation);//update baze
                Intent intent = new Intent(getActivity().getApplicationContext(), ActivityGUI.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().getApplicationContext().startActivity(intent);

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

        private Order order;


        public ItemOrder(Order order){
            this.order = order;


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
            TextView  itemOrder,number_item_order;
            Button  remove;
            CheckedTextView innewRezervations;


            @Override
            public void findViews(View convertView) {
                itemOrder =(TextView) convertView.findViewById(R.id.item_order);
                number_item_order =(TextView) convertView.findViewById(R.id.number_item_order);
                remove = (Button)convertView.findViewById(R.id.remove);
                innewRezervations =(CheckedTextView) convertView.findViewById(R.id.in_new_order);

            }
            @Override
            public void fillData(final ItemOrder adapterItem) {

                itemOrder.setVisibility(View.VISIBLE);
                itemOrder.setText(adapterItem.order.getOrder().getFood());
                remove.setVisibility(View.VISIBLE);

                innewRezervations.setVisibility(View.VISIBLE);
                innewRezervations.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        newRezervation = new Rezervation();
                        newRezervation.setName_user(rezervation.getname_user());
                        newRezervation.setNumberTable(rezervation.getnumberTable());
                        newRezervation.setPaidOrNot(rezervation.isPaidOrNot());
                        Date date = new Date();
                        newRezervation.setTime(date.toString());
                        newRezervation.getOrders().add(order);
                        rezervation.getOrders().remove(order);
                        ((MyCustomAdatperForTheList<ItemOrder>) listaAddOrder.getAdapter()).deleteItemFromAdapter(ItemOrder.this);
                        ((MyCustomAdatperForTheList<ItemOrder>) listaAddOrder.getAdapter()).notifyDataSetChanged();


                    }
                });

                remove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                     rezervation.getOrders().remove(order);//TODO ovde mora da se implementira dobar equals !

                       // ((MyCustomAdatperForTheList<ItemOrder>) listaAddOrder.getAdapter()).deleteItemFromAdapter(ItemOrder.this);

                        MyCustomAdatperForTheList<ItemOrder> adapter = new MyCustomAdatperForTheList(getActivity());
                        try{
                            for (int i=0 ; i<rezervation.getOrders().size();i++) {
                                Order order = rezervation.getOrders().get(i);
                                Order clone = order.clone();
                                adapter.addItem(new ItemOrder(clone));

                            }

                        }catch (Exception e){
                            System.out.print(e.getStackTrace());
                        }
                        listaAddOrder.setAdapter(adapter);
                       ((MyCustomAdatperForTheList<ItemOrder>) listaAddOrder.getAdapter()).notifyDataSetChanged();
                        FreagmentAddOrder.this.listaAddOrder.invalidate();


                    }
                });



            }
        }
    }

}
