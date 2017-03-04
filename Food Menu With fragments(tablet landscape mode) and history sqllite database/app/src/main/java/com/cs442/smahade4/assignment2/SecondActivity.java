package com.cs442.smahade4.assignment2;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by sushma on 10/2/2016.
 */

public class SecondActivity extends Activity implements DetailListFragment.CM {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity2);

        int index=getIntent().getIntExtra("i",0);
        int price=getIntent().getIntExtra("price",0);
        int quantity=getIntent().getIntExtra("quantity",0);
        String name=getIntent().getStringExtra("name");

        String description=getIntent().getStringExtra("description");

        DetailListFragment f2 = (DetailListFragment)getFragmentManager().findFragmentById(R.id.TodoListFragment);
        f2.setC(this);
        f2.getData(index,price,quantity,name,description);


    }
    @Override
    public void respond2(int position,int Quantity)
    {

        getIntent().putExtra("position",position);
        getIntent().putExtra("quantity",Quantity);
        setResult(Activity.RESULT_OK,getIntent());
        finish();

    }

}
