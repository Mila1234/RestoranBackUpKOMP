package com.example.marijaradisavljevic.restoran.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.marijaradisavljevic.restoran.R;
import com.example.marijaradisavljevic.restoran.activiry.ActivityFirst;
import com.example.marijaradisavljevic.restoran.adapters.HolderAdapterItem;
import com.example.marijaradisavljevic.restoran.data.UserData;
import com.example.marijaradisavljevic.restoran.adapters.MyCustomAdatperForTheList;
import com.example.marijaradisavljevic.restoran.database.Rezervation;
import com.example.marijaradisavljevic.restoran.servis.Servis;

import java.util.ArrayList;

/**
 * Created by marija.radisavljevic on 5/13/2016.
 */
public class FragmentListReservations extends Fragment {

    private ListView lvDetail;




    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mRoot = inflater.inflate(R.layout.fragment_list_rezervations_layout, container, false);

        lvDetail = (ListView)mRoot.findViewById(R.id.list_reservations);



        MyCustomAdatperForTheList<ItemForRezervationsList> adapter = new MyCustomAdatperForTheList(getActivity());
        ArrayList<Rezervation> myList = Servis.getInstance().getRezervationsWithRegulation(UserData.getInstance().getSelecionRegulation());
        for(Rezervation rez:myList){
            adapter.addItem(new ItemForRezervationsList(rez));
        }
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


    public class ItemForRezervationsList extends HolderAdapterItem {
        Rezervation rezervation;

        public ItemForRezervationsList(Rezervation ld){

            rezervation = ld;

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
            return R.layout.rezervation;
        }

        @Override
        protected  IViewHolder createViewHolder() {
            return  new RezervationsViewHolder(this);
        }

        private class  RezervationsViewHolder implements IViewHolder<ItemForRezervationsList> {
            ItemForRezervationsList bla;
            TextView time, name_user, numberTable, price, itemsOrder, paidOrNot;
            Button edit, remove;


            public RezervationsViewHolder(ItemForRezervationsList bla) {
                this.bla = bla;
            }

            @Override
            public void findViews(View convertView) {
                time = (TextView)convertView.findViewById(R.id.time);

                numberTable= (TextView)convertView.findViewById(R.id.numberTable);
                price= (TextView)convertView.findViewById(R.id.price);
                itemsOrder = (TextView)convertView.findViewById(R.id.itemsOrder);
                paidOrNot = (TextView)convertView.findViewById(R.id.paidOrNot);
                edit  = (Button)convertView.findViewById(R.id.edit);
                remove = (Button)convertView.findViewById(R.id.remove);
            }
            @Override
            public void fillData(final ItemForRezervationsList adapterItem) {

                time.setVisibility(View.VISIBLE);
                time.setText(adapterItem.rezervation.gettime());

                numberTable.setVisibility(View.VISIBLE);
                numberTable.setText("Broj stola je : " + adapterItem.rezervation.getnumberTable_string());
                price.setVisibility(View.VISIBLE);
                price.setText("Cena je : "+adapterItem.rezervation.getprice().toString());
                itemsOrder.setVisibility(View.VISIBLE);
                itemsOrder.setText(adapterItem.rezervation.getItemsOrdersInString());
                paidOrNot.setVisibility(View.VISIBLE);
                paidOrNot.setText(adapterItem.rezervation.getpaidOrNot_string());


                edit.setVisibility(View.VISIBLE);
                remove.setVisibility(View.VISIBLE);

                edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //otvori prozor fragment FreagmentAddOrder
                        Intent intent2 = new Intent(getActivity().getApplicationContext(), ActivityFirst.class);
                        intent2.putExtra("name", "FreagmentAddOrder");
                        intent2.putExtra("rezervationId", Integer.toString(rezervation.getId()));

                        intent2.putExtra("action", "onclick");
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getActivity().getApplicationContext().startActivity(intent2);

                    }
                });

               // remove.setOnClickListener(this);
                remove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       // AdapterDB.getInstance().deleteRezervation(rezervation.getId());


                        Servis.getInstance().removeRezer(rezervation.getId());
                        MyCustomAdatperForTheList<ItemForRezervationsList> adapter = new MyCustomAdatperForTheList(getActivity());
                        ArrayList<Rezervation> myList = Servis.getInstance().getRezervationsWithRegulation(UserData.getInstance().getSelecionRegulation());
                        for(Rezervation rez:myList){
                            adapter.addItem(new ItemForRezervationsList(rez));
                        }
                        lvDetail.setAdapter(adapter);

                        //////////////////

                        FragmentListReservations.this.lvDetail.invalidateViews();


                    }
                });
            }
        }
    }



}
