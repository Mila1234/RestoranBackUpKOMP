package com.example.marijaradisavljevic.restoran.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.marijaradisavljevic.restoran.R;

/**
 * Created by marija.radisavljevic on 5/19/2016.
 */
public class ItemOrder extends HolderAdapterItem {

    private String time,name_user,numberTable,price,itemsOrder,paidOrNot;

    public ItemOrder(ListData ld){
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
        return  new OrderViewHolder();
    }

    private class  OrderViewHolder implements IViewHolder<ItemForRezervationsList> {
        TextView time, name_user, numberTable, price, itemsOrder, paidOrNot;
        Button edit, remove;


        @Override
        public void findViews(View convertView) {

        }
        @Override
        public void fillData(final ItemForRezervationsList adapterItem) {


        }
    }
}
