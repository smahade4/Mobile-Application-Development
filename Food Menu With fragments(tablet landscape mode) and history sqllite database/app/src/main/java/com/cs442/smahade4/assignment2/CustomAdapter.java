package com.cs442.smahade4.assignment2;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
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
      /*  Button btnadd=(Button) rowView.findViewById(R.id.buttonadd);

        btnadd.setBackgroundResource(R.drawable.a6);
        btnadd.setOnClickListener(this);
       Button btnremove=(Button) rowView.findViewById(R.id.buttonremove);

       btnremove.setOnClickListener(this);
        btnremove.setBackgroundResource(R.drawable.a4);
    */
        imageView.setImageResource(resID);
        TextView textid=(TextView) rowView.findViewById(R.id.textid);
        textid.setText(String.valueOf(menudetails.get(position).getmenuid()));
        TextView textname=(TextView) rowView.findViewById(R.id.textname);
        textname.setText(menudetails.get(position).getmenuname());
        TextView textrate=(TextView) rowView.findViewById(R.id.textrate);
        textrate.setText("$"+String.valueOf(menudetails.get(position).getmenuprice()));
        TextView textquantity=(TextView) rowView.findViewById(R.id.textquantitiy);
        textquantity.setText(String.valueOf(menudetails.get(position).getmenuquantity()));

        return rowView;

    };

    /*@Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.buttonadd) {
            View parentRow = (View) v.getParent();
            ListView listView = (ListView) parentRow.getParent();
            final int position = listView.getPositionForView(parentRow);
            int quantity = menudetails.get(position).getmenuquantity();
            int price = menudetails.get(position).getmenuprice();
            quantity = quantity + 1;
            menudetails.get(position).setmenuquantity(quantity);
            int total=Integer.parseInt(secondactivityfragment.s.getText().toString()) + (price);
            secondactivityfragment.s.setText(String.valueOf(total));
            notifyDataSetChanged();
        }
        else
        if(v.getId()==R.id.buttonremove)
        {
            View parentRow = (View) v.getParent();
            ListView listView = (ListView) parentRow.getParent();
            final int position = listView.getPositionForView(parentRow);
            int quantity = menudetails.get(position).getmenuquantity();
            int price = menudetails.get(position).getmenuprice();
            int total=Integer.parseInt(secondactivityfragment.s.getText().toString()) - price;
            quantity = quantity - 1;
            if(quantity>=0) {
                menudetails.get(position).setmenuquantity(quantity);
                    secondactivityfragment.s.setText(String.valueOf(total));
            }
            notifyDataSetChanged();

        }
    }*/


}