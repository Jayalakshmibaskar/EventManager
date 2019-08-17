package com.example.revathy.events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class



MyAdapter extends BaseAdapter {

    ArrayList list;
    Context context;
    LayoutInflater inflater;
    public MyAdapter(ArrayList list, Context context) {
        this.list = list;
        this.context = context;
        this.inflater=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.image,null,true);
//        ImageView iv=convertView.findViewById(R.id.image);
//        iv.setImageResource((int)list.get(position));
        TextView tv=convertView.findViewById(R.id.name);
        tv.setText(list.get(position).toString());
        return convertView;
    }
}
