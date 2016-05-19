package com.example.marijaradisavljevic.restoran.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.marijaradisavljevic.restoran.R;

/**
 * Created by marija.radisavljevic on 5/19/2016.
 */
public class ItemForRezervationsList extends HolderAdapterItem{

    private String time,name_user,numberTable,price,itemsOrder,paidOrNot;

public ItemForRezervationsList(ListData ld){
    time = ld.gettime();
    name_user = ld.getname_user();
    numberTable = ld. getnumberTable();
    price = ld.getprice();
    itemsOrder = ld.getitemsOrder();
    paidOrNot = ld.getpaidOrNot();

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
        return  new RezervationsViewHolder();
    }

    private class  RezervationsViewHolder implements IViewHolder<ItemForRezervationsList> {
        TextView time, name_user, numberTable, price, itemsOrder, paidOrNot;
        Button edit, remove;


        @Override
        public void findViews(View convertView) {
            time = (TextView)convertView.findViewById(R.id.time);
            name_user= (TextView)convertView.findViewById(R.id.name_user);
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
            time.setText(adapterItem.time);
            name_user.setVisibility(View.VISIBLE);
            name_user.setText(adapterItem.name_user);
            numberTable.setVisibility(View.VISIBLE);
            numberTable.setText(adapterItem.numberTable);
            price.setVisibility(View.VISIBLE);
            price.setText(adapterItem.price);
            itemsOrder.setVisibility(View.VISIBLE);
            itemsOrder.setText(adapterItem.itemsOrder);
            paidOrNot.setVisibility(View.VISIBLE);
            paidOrNot.setText(adapterItem.paidOrNot);

            edit.setVisibility(View.VISIBLE);
            remove.setVisibility(View.VISIBLE);

            edit.setOnClickListener(new View.OnClickListener() {
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
