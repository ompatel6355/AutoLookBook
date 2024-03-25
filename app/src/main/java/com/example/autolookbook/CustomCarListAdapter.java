package com.example.autolookbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomCarListAdapter extends BaseAdapter {

    Context context;
    String carList[];
    int carImageList[];
    LayoutInflater inflater;

    public CustomCarListAdapter (Context context, String [] carList, int [] carImageList) {
        this.context = context;
        this.carList = carList;
        this.carImageList = carImageList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return carList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView textView = (TextView) convertView.findViewById(R.id.carName);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.carIcon);
        textView.setText(carList[position]);
        imageView.setImageResource(carImageList[position]);
        return convertView;
    }
}
