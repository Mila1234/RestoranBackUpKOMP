package com.example.marijaradisavljevic.restoran.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.marijaradisavljevic.restoran.R;

import java.util.ArrayList;

/**
 * Created by marija.radisavljevic on 5/13/2016.
 */
public class MyCustomAdatperForTheList extends BaseAdapter{


    ArrayList<ListData> myList = new ArrayList<ListData>();
    LayoutInflater inflater;
    Context context;

    public MyCustomAdatperForTheList(Context context, ArrayList<ListData> myList) {
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
            convertView = inflater.inflate(R.layout.layout_list_item, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        ListData currentListData = getItem(position);

        mViewHolder.tvTitle.setText(currentListData.getTitle());
        mViewHolder.tvDesc.setText(currentListData.getDescription());
        mViewHolder.ivIcon.setImageResource(currentListData.getImgResId());

        return convertView;
    }


    private class MyViewHolder {//have fild like views in
        TextView tvTitle, tvDesc;
        ImageView ivIcon;

        public MyViewHolder(View item) {
            tvTitle = (TextView) item.findViewById(R.id.tvTitle);
            tvDesc = (TextView) item.findViewById(R.id.tvDesc);
            ivIcon = (ImageView) item.findViewById(R.id.ivIcon);
        }
    }



}
