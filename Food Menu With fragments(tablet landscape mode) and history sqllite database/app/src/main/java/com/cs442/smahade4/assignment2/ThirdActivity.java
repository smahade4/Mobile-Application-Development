package com.cs442.smahade4.assignment2;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by sushma on 10/7/2016.
 */

public class ThirdActivity extends Activity implements TotalActivityFragment.CM{

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity3);

        int index=getIntent().getIntExtra("i",0);
        int price=getIntent().getIntExtra("price",0);
        int quantity=getIntent().getIntExtra("quantity",0);
        String name=getIntent().getStringExtra("name");

        String description=getIntent().getStringExtra("description");

        TotalActivityFragment totalFragment = (TotalActivityFragment)getFragmentManager().findFragmentById(R.id.TotalFragment);
        totalFragment.setC(this);


    }
    @Override
    public void respondFinal()
    {

    }


}
