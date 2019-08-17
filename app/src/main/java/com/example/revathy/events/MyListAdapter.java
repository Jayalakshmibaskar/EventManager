package com.example.revathy.events;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class    MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] event;
    private final String[] desc;
    private final Integer[] event_image;

    public MyListAdapter(Activity context, String[] event, Integer[] event_image,String[] desc) {
        super(context, R.layout.image, event);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.event = event;
        this.desc=desc;
        this.event_image = event_image;

    }
    public View getView(int position,View convertView,ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder=null;
        if (r==null){
            LayoutInflater layoutInflater= context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.image,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder)r.getTag();
        }
        viewHolder.image.setImageResource(event_image[position]);
        viewHolder.name.setText(event[position]);
        viewHolder.description.setText(desc[position]);
        return r;
    };
    class ViewHolder{
        TextView name,description;
        ImageView image;
        ViewHolder(View view){
            name= view.findViewById(R.id.name);
            description=view.findViewById(R.id.description);
            image=view.findViewById(R.id.image);


        }


    }
}