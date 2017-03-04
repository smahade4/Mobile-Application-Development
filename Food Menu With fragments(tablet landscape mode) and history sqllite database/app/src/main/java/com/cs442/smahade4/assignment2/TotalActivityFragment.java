package com.cs442.smahade4.assignment2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sushma on 10/7/2016.
 */

public class TotalActivityFragment extends Fragment implements Button.OnClickListener{
        CM c;
    ArrayList<Menu> orderedList;
    ListView selectedList;

    CustomAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        View view = inflater.inflate(R.layout.thirdactivityfragment, container, false);
        // Exception at this line
        selectedList = (ListView) view.findViewById(R.id.selectedList);
        orderedList=new ArrayList();
        adapter=new CustomAdapter(this.getActivity(), orderedList);

        selectedList.setAdapter(adapter);

        Button btnCheckOut= (Button)view.findViewById(R.id.buttonCheckOut);

        btnCheckOut.setOnClickListener(this);

        System.out.print("ok");
        return view;
    }

    public void setC(CM c)
    {
        this.c=c;
    }
    @Override
    public void onClick( View v) {
        c.respondFinal();

    }


    public void totalData(ArrayList<Menu> orderedList)
    {
            this.orderedList=orderedList;
        adapter=new CustomAdapter(this.getActivity(), orderedList);

        selectedList.setAdapter(adapter);

           System.out.println("working");

       }
    public interface CM
    {

        public void respondFinal();

    }

}
