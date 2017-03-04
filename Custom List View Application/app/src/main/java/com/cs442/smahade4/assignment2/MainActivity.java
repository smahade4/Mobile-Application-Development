package com.cs442.smahade4.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Menu> menudetails;
    ListView menulist;
    CustomAdapter adapter;
     int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText myEditText = (EditText)findViewById(R.id.myEditText);
        menulist = (ListView) findViewById(R.id.myListView);
        //create Array list of menu items
        menudetails = new ArrayList();
        id=id+1;
        menudetails.add(new Menu(id,"@drawable/strudels","Noodle with taste of cinnamon made with hot chilly sauce","Strudels",10));
        id=id+1;
        menudetails.add(new Menu(id,"@drawable/soup","Tangy Soup with taste of mint and ginger","Soup",12));
        id=id+1;
        menudetails.add(new Menu(id,"@drawable/pizza","Cheese and cucumber Pizza Thin Chrust " +
                "with topping of mushroom and black olives","Pizza",15));
        id=id+1;
        menudetails.add(new Menu(id,"@drawable/pasta","Jalapeno and Capsicum Pasta with white sauce and oregano seasonings","Pasta",20));
        id=id+1;
        menudetails.add(new Menu(id,"@drawable/a4","Dark Chocolate Chip and Strawberry cakes with layer of cinnamon sticks ","Desserts",20));
        id=id+1;
        menudetails.add(new Menu(id,"@drawable/b6","Strawberry and Mango Milkshakes and juices ","Appetizers",20));

        //adapter= new ArrayAdapter<Menu>(this,
               // android.R.layout.simple_list_item_1, menudetails);


        menudetails=sort();

        adapter=new CustomAdapter(this, menudetails);

        menulist.setAdapter(adapter);
        Button myButton = (Button)findViewById(R.id.addmenu);
        // on button click add the editbox menu item to list
        //check if the edit box contains 4 values seperated from comma
        // that is the name,price,description,image name
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myEditText.getText().toString().length()>0)
                {
                    String[] menu= myEditText.getText().toString().split(",");
                    System.out.println("length is"+menu.length);
                    if(menu.length<3 || menu.length>3)
                    {
                        Toast toast= Toast.makeText(getApplicationContext(), "You have not specified Correct parameters" , Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        toast.show();
                    }

                    if (menu.length == 3) {
                        if(menu[0].isEmpty()||menu[2].isEmpty()||menu[1].isEmpty())
                        {
                            Toast toast= Toast.makeText(getApplicationContext(), "You have not specified All parameters" , Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                            toast.show();
                        }
                        if(menu[1].matches("[0-9]+")) {
                            id= id + 1;
                            menudetails.add(new Menu(id, "@drawable/a6", menu[2], menu[0], Integer.parseInt(menu[1])));
                            menudetails=sort();
                            adapter.notifyDataSetChanged();
                        }

                        else
                        {
                            Toast toast= Toast.makeText(getApplicationContext(), "Price should be number" , Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                            toast.show();

                        }
                    }
                }
                else
                {
                    Toast toast= Toast.makeText(getApplicationContext(), "You have not specified Correct parameters" , Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();
                }
                myEditText.setText("");

            }
        });

        //on click of the list display menu descripton in toast message
       menulist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Toast toast= Toast.makeText(getApplicationContext(), "" +menudetails.get(position).getmenudescription(), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
            }
        });

        //on listview longclick remove the item from the list and display toast message
        menulist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String menuname=menudetails.get(position).getmenuname();
                menudetails.remove(position);
                adapter.notifyDataSetChanged();
                System.out.println("inside onlong");
                Toast toast= Toast.makeText(getApplicationContext(), menuname+" removed from menu", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
                return true;
            }
        });


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
}
