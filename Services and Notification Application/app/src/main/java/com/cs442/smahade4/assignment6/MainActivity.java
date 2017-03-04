package com.cs442.smahade4.assignment6;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {
    EditText editText;
    Button btn1;
    Button btn2;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);


        //Get the edittext value for counter value
        editText=(EditText)findViewById(R.id.editText);
        if (savedInstanceState != null) {
            flag = savedInstanceState.getInt("value");
        }
        System.out.println(flag);
        SharedPreferences pref = getSharedPreferences("data", 0);
        flag=pref.getInt("value",0);

        if(flag==0)
        {
            btn1.setEnabled(true);
            btn2.setEnabled(false);

        }
        if(flag==1)
        {
            btn2.setEnabled(true);
            btn1.setEnabled(false);
        }

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        int id=v.getId();
        Intent intent = new Intent(this, ServiceClass.class);
        //On cliking start service button start the service and pass the iniial counter value
        //Service will be started with the counter start number from EditView.
        // If EditView entered text is not a number it will start from 1.
        if(id==R.id.button1)
        {
            int counter;
            String data=editText.getText().toString();

            if(data.matches("[0-9]+"))
            {
                counter = Integer.parseInt(data);
                //display toast messsage that service is started
                Toast.makeText(this, "Service Started with Counter "+data, Toast.LENGTH_SHORT).show();
            }
            else
            {
                counter = 1;
                Toast.makeText(this, "Service Started with Counter "+1, Toast.LENGTH_SHORT).show();
            }
            intent.putExtra("counter", counter);

            startService(intent);
            //disable start service button after service is started
            btn2.setEnabled(true);
            btn1.setEnabled(false);
            flag=1;
        }

        if(id==R.id.button2)
        {
            stopService(intent);
            Toast.makeText(this, "Service and Notification Stopped", Toast.LENGTH_SHORT).show();
            btn1.setEnabled(true);
            btn2.setEnabled(false);
            flag=0;
        }

    }
    @Override
    public void onDestroy()
    {
        // on destroy state information will be stored if the service is running or is stopped
        SharedPreferences pref = getSharedPreferences("data",0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("value",flag);
        editor.commit();
        super.onDestroy();
    }

    @Override
    public void onStop()
    {

        // on stop state information will be stored if the service is running or is stopped
        SharedPreferences pref = getSharedPreferences("data",0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("value",flag);
        super.onStop();
    }
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
        // saving instance state if home button is pressed or application is closed

        savedInstanceState.putInt("value", flag);

        super.onSaveInstanceState(savedInstanceState);
    }


    public void stopService(View view) {
        //stop the service
        stopService(new Intent(this, ServiceClass.class));

    }
}
