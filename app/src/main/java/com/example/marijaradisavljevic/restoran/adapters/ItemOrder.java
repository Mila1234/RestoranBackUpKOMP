package com.example.marijaradisavljevic.restoran.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.example.marijaradisavljevic.restoran.R;


import java.util.ArrayList;

/**
 * Created by marija.radisavljevic on 5/19/2016.
 */
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
