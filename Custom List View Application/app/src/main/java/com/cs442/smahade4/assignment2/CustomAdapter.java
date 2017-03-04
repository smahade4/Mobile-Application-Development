package com.cs442.smahade4.assignment2;
import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private final Activity context;
    private  ArrayList<Menu> menudetails=null;

    public CustomAdapter(Activity context, ArrayList<Menu> menudetails) {

        this.context=context;
        this.menudetails=menudetails;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }
    @Override
    public int getCount()
    {
        return menudetails.size();
    }
    @Override
    public Object getItem(int position) {
        return menudetails.get(position);
    }

 //set the text and image in the display to the position value from arraylist and set text and image to list
    public View getView(int position,View view,ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.linear, null);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        Resources res = context.getResources();
        int resID = res.getIdentifier(menudetails.get(position).getmenuimage() , "drawable", context.getPackageName());

        imageView.setImageResource(resID);
        TextView textid=(TextView) rowView.findViewById(R.id.textid);
        textid.setText(String.valueOf(menudetails.get(position).getmenuid()));
        TextView textname=(TextView) rowView.findViewById(R.id.textname);
        textname.setText(menudetails.get(position).getmenuname());
        TextView textrate=(TextView) rowView.findViewById(R.id.textrate);
        textrate.setText("$"+String.valueOf(menudetails.get(position).getmenuprice()));

        return rowView;

    };
}