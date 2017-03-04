package com.cs442.dsuraj.quantumc;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class mylist extends ArrayAdapter<String> {
    ArrayList<String> arraylist;
    private final Activity context;
    public mylist(Activity context, ArrayList<String> arrayList)
    {
        super(context,R.layout.activity_list);
        this.arraylist = arrayList;
        this.context = context;
    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.text);
        txtTitle.setText(arraylist.get(0));
        return rowView;

    };
    }

