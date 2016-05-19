package com.example.marijaradisavljevic.restoran.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.marijaradisavljevic.restoran.R;

import java.util.ArrayList;

/**
 * Created by marija.radisavljevic on 5/13/2016.
 */
public class MyCustomAdatperForTheList<T> extends BaseAdapter{


    ArrayList<T> myList = new ArrayList<T>();
    LayoutInflater inflater;
    Context context;

    public MyCustomAdatperForTheList(Context context, ArrayList<T> myList) {
        this.myList = myList;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }
    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.rezervation, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        T currentListData = (T )getItem(position);

     /*   mViewHolder.time.setText(currentListData.gettime());
        mViewHolder.name_user.setText(currentListData.getname_user());
        mViewHolder.numberTable.setText(currentListData.getnumberTable());
        mViewHolder.price.setText(currentListData.getprice());
        mViewHolder.itemsOrder.setText(currentListData.getitemsOrder());
        mViewHolder.paidOrNot.setText(currentListData.getpaidOrNot());*/

        return convertView;
    }


    private class MyViewHolder {//have fild like views in
        TextView time, name_user,numberTable,price,itemsOrder,paidOrNot;
        Button edit,remove;

        public MyViewHolder(View item) {
            time = (TextView) item.findViewById(R.id.time);
            name_user = (TextView) item.findViewById(R.id.name_user);
            numberTable = (TextView) item.findViewById(R.id.numberTable);
            price = (TextView) item.findViewById(R.id.price);
            itemsOrder = (TextView) item.findViewById(R.id.itemsOrder);
            paidOrNot = (TextView) item.findViewById(R.id.paidOrNot);
        }
    }



}
