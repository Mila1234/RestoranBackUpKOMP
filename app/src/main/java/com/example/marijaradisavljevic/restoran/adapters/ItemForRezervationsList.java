package com.example.marijaradisavljevic.restoran.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by marija.radisavljevic on 5/19/2016.
 */
public class ItemForRezervationsList extends HolderAdapterItem{

    @Override
    public boolean isEnabled() {
        return false;
    }

    private String time,name_user,numberTable,price,itemsOrder,paidOrNot;

    @Override
    public View getView(Context context, View convertView, ViewGroup parent) {
        return super.getView(context, convertView, parent);
    }

    @Override
    protected int getViewLayoutResId() {
        return 0;
    }

    @Override
    protected <T extends HolderAdapterItem> IViewHolder<T> createViewHolder() {
        return null;
    }
}
