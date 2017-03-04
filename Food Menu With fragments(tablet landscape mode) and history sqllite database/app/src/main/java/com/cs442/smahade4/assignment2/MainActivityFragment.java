package com.cs442.smahade4.assignment2;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sushma on 10/1/2016.
 */

public class MainActivityFragment extends Fragment implements ListView.OnItemClickListener,TextView.OnClickListener{
    CM c;
    ArrayList<Menu> menudetails;

    ArrayList<Menu> selectedList;
    ListView menulist;
    CustomAdapter adapter;
    int id=0;
    int total=0;
    static TextView s;
    String menuname="";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.layout,container,false);
        menulist = (ListView) view.findViewById(R.id.myListView);
        //create Array list of menu items
        menudetails = new ArrayList();
        id=id+1;
        menudetails.add(new Menu(id,"@drawable/strudels","Noodle with taste of cinnamon made with hot chilly sauce","Strudels",10,0));
        id=id+1;
        menudetails.add(new Menu(id,"@drawable/soup","Tangy Soup with taste of mint and ginger","Soup",12,0));
        id=id+1;
        menudetails.add(new Menu(id,"@drawable/pizza","Cheese and cucumber Pizza Thin Chrust " +
                "with topping of mushroom and black olives","Pizza",15,0));
        id=id+1;
        menudetails.add(new Menu(id,"@drawable/pasta","Jalapeno and Capsicum Pasta with white sauce and oregano seasonings","Pasta",20,0));
        id=id+1;
        menudetails.add(new Menu(id,"@drawable/a4","Dark Chocolate Chip and Strawberry cakes with layer of cinnamon sticks ","Desserts",20,0));
        id=id+1;
        menudetails.add(new Menu(id,"@drawable/b6","Strawberry and Mango Milkshakes and juices ","Appetizers",20,0));
        total=0;
        s=  (TextView) view.findViewById(R.id.total);
        s.setText(String.valueOf(total));

        menudetails=sort();

        adapter=new CustomAdapter(this.getActivity(), menudetails);

        menulist.setAdapter(adapter);
        menulist.setOnItemClickListener(this);
        s.setOnClickListener(this);
        return view;
    }

  public void setC(CM c)
  {
    this.c=c;
  }
 public interface CM
 {
    public void respond(int i,int price,int quantity,String name,String Description);

     public void respondTotal(ArrayList<Menu> selectedList);


 }
    //to sort the menulist in descending order
    public ArrayList<Menu> sort()
    {
        Collections.sort(menudetails, new Comparator<Menu>() {
            @Override
            public int compare(Menu obj1,Menu obj2) {
                if(obj1.getmenuid()<obj2.getmenuid())
                    return 1;
                else
                    return -1;
            }
        });
        return menudetails;
    }
    @Override
    public void onClick(View v) {
        selectedList=new ArrayList<Menu>();
            for (int i=0;i<menudetails.size();i++) {
                if (menudetails.get(i).getmenuquantity() > 0) {
                    int menuid=menudetails.get(i).getmenuid();
                    int menuprice = menudetails.get(i).getmenuprice();
                    int menuquantity = menudetails.get(i).getmenuquantity();
                    String menuname = menudetails.get(i).getmenuname();
                    String description = menudetails.get(i).getmenudescription();
                    Menu m=new Menu( menuid,"",description, menuname,  menuprice, menuquantity);
                    selectedList.add(m);
                }
            }
        c.respondTotal(selectedList);

    }


    @Override
   public void onItemClick(AdapterView va,View v,int i,long l)
   {
    int price=menudetails.get(i).getmenuprice();
       int quantity=menudetails.get(i).getmenuquantity();
        String name=menudetails.get(i).getmenuname();
       String description=menudetails.get(i).getmenudescription();

       c.respond(i,price,quantity,name,description);
   }

  public void changeData(int position,int quantity)
  {
      menudetails.get(position).setmenuquantity(quantity);
        adapter.notifyDataSetChanged();
        total=Integer.parseInt(s.getText().toString())+(quantity*menudetails.get(position).getmenuprice());
          s.setText(String.valueOf(total));

      /*
      adapter=new CustomAdapter(this.getActivity(), menudetails);
      menulist.setAdapter(adapter);
      menulist.setOnItemClickListener(this);
        */
  }


    public void changeTotal()
    {
        s.setText("0");
        for(int i=0;i<menudetails.size();i++)
        {
            menudetails.get(i).setmenuquantity(0);
        }
        adapter.notifyDataSetChanged();
           /*
      adapter=new CustomAdapter(this.getActivity(), menudetails);
      menulist.setAdapter(adapter);
      menulist.setOnItemClickListener(this);
        */
    }

}
