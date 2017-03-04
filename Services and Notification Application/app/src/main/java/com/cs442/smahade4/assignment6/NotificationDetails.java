package com.cs442.smahade4.assignment6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by sushma on 10/23/2016.
 */

public class NotificationDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notificationdetails);
        //New Activity for Notifcation Screen
        // When user clicks on the notification this page will display with the current counter
        String val=getIntent().getStringExtra("count");
        TextView txt1=(TextView)findViewById(R.id.CounterText);
        txt1.setText(txt1.getText().toString()+val);
        }

    }
