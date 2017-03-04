package com.cs442.smahade4.assignment2;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivity extends Activity implements MainActivityFragment.CM ,DetailListFragment.CM,TotalActivityFragment.CM{
    MainActivityFragment f1;
    DetailListFragment f2;
    TotalActivityFragment f3;

    FragmentManager m;

    public void onCreate(Bundle instance)
    {   super.onCreate(instance);
       setContentView(R.layout.activity_main);
        m=getFragmentManager();
        f1=(MainActivityFragment)m.findFragmentById(R.id.NewItemFragment);
        f1.setC(this);
        f2 = (DetailListFragment)m.findFragmentById(R.id.TodoListFragment);
        f3 = (TotalActivityFragment) m.findFragmentById(R.id.TotalFragment);
        if(f2!=null) {
            f2.getView().setVisibility(View.INVISIBLE);
        }
        if(f3!=null) {
            f3.getView().setVisibility(View.INVISIBLE);
        }
    }




    @Override
    public void respond(int i,int price,int quantity,String name,String description)
    {

        f3 = (TotalActivityFragment) m.findFragmentById(R.id.TotalFragment);
        if(f3!=null ){
            ViewGroup.LayoutParams params = f3.getView().getLayoutParams();
            params.width = 0;
        f3.getView().setLayoutParams(params);
        f3.getView().setVisibility(View.INVISIBLE);
        }

        f2 = (DetailListFragment)m.findFragmentById(R.id.TodoListFragment);
        if(f2!=null) {
            ViewGroup.LayoutParams params = f2.getView().getLayoutParams();
            params.width = 1000;
            f2.getView().setLayoutParams(params);
            f2.getView().setVisibility(View.VISIBLE);
            if (f2.isVisible()) {
                f2.setC(this);

                f2.getData(i, price, quantity, name, description);
            }
        }
        else
        {
            System.out.print("okdata");
            Intent intent=new Intent(this,SecondActivity.class);
            intent.putExtra("i",i);
            intent.putExtra("price",price);
            intent.putExtra("description",description);
            intent.putExtra("quantity",quantity);
            intent.putExtra("name",name);
            startActivityForResult(intent,1);
        }
    }

    @Override
    public void respondTotal(ArrayList<Menu> selectedList) {
        f2 = (DetailListFragment) m.findFragmentById(R.id.TodoListFragment);

        if (f2 != null) {
            ViewGroup.LayoutParams params = f2.getView().getLayoutParams();
            params.width = 0;
            f2.getView().setLayoutParams(params);

            f2.getView().setVisibility(View.INVISIBLE);
        }
        f3 = (TotalActivityFragment) m.findFragmentById(R.id.TotalFragment);
        if (f3 != null) {
            ViewGroup.LayoutParams params = f3.getView().getLayoutParams();
            params.width = 1000;

            f3.getView().setLayoutParams(params);

            f3.getView().setVisibility(View.VISIBLE);

            if(f3.isVisible())
            {
            f3.setC(this);
                f3.totalData(selectedList);
        }
       }
            else
            {
                Intent intent=new Intent(this,ThirdActivity.class);
                startActivityForResult(intent,1);
            }



        /*if(f2!=null && f2.isVisible())
        {
            f2.setC(this);

            f2.getData(i,price,quantity,name,description);

        }
        else
        {
            System.out.print("okdata");
            Intent intent=new Intent(this,SecondActivity.class);
            intent.putExtra("i",i);
            intent.putExtra("price",price);
            intent.putExtra("description",description);
            intent.putExtra("quantity",quantity);
            intent.putExtra("name",name);
            startActivityForResult(intent,1);
        }*/
    }
    @Override
    public void respond2(int position,int quantity)
    {
        f1=(MainActivityFragment) m.findFragmentById(R.id.NewItemFragment);
        System.out.print("changing");
        if(f1!=null && f1.isVisible())
        {
            f1.changeData(position,quantity);
        }

    }


    @Override
    public void respondFinal()
    {
        f1=(MainActivityFragment) m.findFragmentById(R.id.NewItemFragment);
        System.out.print("changing");
        if(f1!=null && f1.isVisible())
        {
            f1.changeTotal();
        }

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

            if (resultCode == Activity.RESULT_OK) {
                 int quantity=data.getIntExtra("quantity",0);

                int position=data.getIntExtra("position",0);

                System.out.print(quantity);

                f1=(MainActivityFragment) m.findFragmentById(R.id.NewItemFragment);
                if(f1!=null && f1.isVisible())
                {
                    f1.changeData(position,quantity);
                }

          }
        }
    }


