package com.cs442.dsuraj.quantumc;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeatSelection extends AppCompatActivity {

    ImageButton A1,A2,A3,A4,A5,A6,A7;
    ImageButton B1,B2,B3,B4,B5,B6,B7;
    ImageButton C1,C2,C3,C4,C5,C6,C7;
    ImageButton D1,D2,D3,D4,D5,D6,D7;
    int select_A1=0,select_A2=0,select_A3=0,select_A4=0,select_A5=0,select_A6=0,select_A7=0;
    int select_B1=0,select_B2=0,select_B3=0,select_B4=0,select_B5=0,select_B6=0,select_B7=0;
    int select_C1=0,select_C2=0,select_C3=0,select_C4=0,select_C5=0,select_C6=0,select_C7=0;
    int select_D1=0,select_D2=0,select_D3=0,select_D4=0,select_D5=0,select_D6=0,select_D7=0;



    ArrayList<String> arrayList= new ArrayList<String>();
    ArrayList<String> arrayList1= new ArrayList<String>();
    SQLiteDatabase sql;
    DatabaseHelper db;
    ArrayList<ArrayList<String>> outer = new ArrayList<ArrayList<String>>();
    int seats_counter =0 ;

    String temp, temp1;
    int colorid;
    int flag=0;
    Bundle bundle;

    int movie;
    String date;
    String theatre;
    String time;
    String seats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_selection);
        db=new DatabaseHelper(getApplicationContext());
        sql=db.getReadableDatabase();
        A1 = (ImageButton)findViewById(R.id.A1);
        A2 = (ImageButton)findViewById(R.id.A2);
        A3 = (ImageButton)findViewById(R.id.A3);
        A4 = (ImageButton)findViewById(R.id.A4);
        A5 = (ImageButton)findViewById(R.id.A5);
        A6 = (ImageButton)findViewById(R.id.A6);
        A7 = (ImageButton)findViewById(R.id.A7);

        B1 = (ImageButton)findViewById(R.id.B1);
        B2 = (ImageButton)findViewById(R.id.B2);
        B3 = (ImageButton)findViewById(R.id.B3);
        B4 = (ImageButton)findViewById(R.id.B4);
        B5 = (ImageButton)findViewById(R.id.B5);
        B6 = (ImageButton)findViewById(R.id.B6);
        B7 = (ImageButton)findViewById(R.id.B7);

        C1 = (ImageButton)findViewById(R.id.C1);
        C2 = (ImageButton)findViewById(R.id.C2);
        C3 = (ImageButton)findViewById(R.id.C3);
        C4 = (ImageButton)findViewById(R.id.C4);
        C5 = (ImageButton)findViewById(R.id.C5);
        C6 = (ImageButton)findViewById(R.id.C6);
        C7 = (ImageButton)findViewById(R.id.C7);

        D1 = (ImageButton)findViewById(R.id.D1);
        D2 = (ImageButton)findViewById(R.id.D2);
        D3 = (ImageButton)findViewById(R.id.D3);
        D4 = (ImageButton)findViewById(R.id.D4);
        D5 = (ImageButton)findViewById(R.id.D5);
        D6 = (ImageButton)findViewById(R.id.D6);
        D7 = (ImageButton)findViewById(R.id.D7);



        Bundle b = getIntent().getExtras();
        movie = b.getInt("movie_id");
        date = b.getString("date");
        theatre = b.getString("theatre");
        time = b.getString("time");

        // while should encompass the below code and forloop
        int j=0;
        String seating="";
        System.out.print(theatre);

        Cursor seatnos = db.getseats(sql,theatre, date, time,movie);
        System.out.print("   " + seatnos.getCount());

        if(seatnos !=null && seatnos.getCount() >0) {
            System.out.print(seating);
            while (seatnos.moveToNext()) {
                if ( j==0) {
                    seating = seatnos.getString(0);

                } else if (seatnos.getCount() >1) {
                    seating = seating + ',';
                    if (!seatnos.isLast()) {
                        seating = seating + seatnos.getString(0);
                    } else {
                        seating = seating + seatnos.getString(0);
                    }
                }
                j++;
            }

            System.out.print("fassdfsdsdfssdfssdf " + seating);
            List<String> seats_booked = Arrays.asList(seating.split(","));


            for (int i = 0; i < seats_booked.size(); i++) {
                System.out.println("Split String: " + seats_booked.get(i));
                if ("A1".equals(seats_booked.get(i))) {
                    A1.setImageResource(R.drawable.seat3);
                    select_A1=1;
                } else if ("A2".equals(seats_booked.get(i))) {
                    A2.setImageResource(R.drawable.seat3);
                    select_A2=1;
                } else if ("A3".equals(seats_booked.get(i))) {
                    A3.setImageResource(R.drawable.seat3);
                    select_A3=1;
                } else if ("A4".equals(seats_booked.get(i))) {
                    A4.setImageResource(R.drawable.seat3);
                    select_A4=1;
                } else if ("A5".equals(seats_booked.get(i))) {
                    A5.setImageResource(R.drawable.seat3);
                    select_A5=1;
                } else if ("A6".equals(seats_booked.get(i))) {
                    A6.setImageResource(R.drawable.seat3);
                    select_A6=1;
                } else if ("A7".equals(seats_booked.get(i))) {
                    A7.setImageResource(R.drawable.seat3);
                    select_A7=1;
                }else if ("B1".equals(seats_booked.get(i))) {
                    B1.setImageResource(R.drawable.seat3);
                    select_B1=1;
                } else if ("B2".equals(seats_booked.get(i))) {
                    B2.setImageResource(R.drawable.seat3);
                    select_B2=1;
                } else if ("B3".equals(seats_booked.get(i))) {
                    B3.setImageResource(R.drawable.seat3);
                    select_B3=1;
                } else if ("B4".equals(seats_booked.get(i))) {
                    B4.setImageResource(R.drawable.seat3);
                    select_B4=1;
                } else if ("B5".equals(seats_booked.get(i))) {
                    B5.setImageResource(R.drawable.seat3);
                    select_B5=1;
                } else if ("B6".equals(seats_booked.get(i))) {
                    B6.setImageResource(R.drawable.seat3);
                    select_B6=1;
                } else if ("B7".equals(seats_booked.get(i))) {
                    B7.setImageResource(R.drawable.seat3);
                    select_B7=1;
                } else if ("C1".equals(seats_booked.get(i))) {
                    C1.setImageResource(R.drawable.seat3);
                    select_C1=1;
                } else if ("C2".equals(seats_booked.get(i))) {
                    C2.setImageResource(R.drawable.seat3);
                    select_C2=1;
                } else if ("C3".equals(seats_booked.get(i))) {
                    C3.setImageResource(R.drawable.seat3);
                    select_C3=1;
                } else if ("C4".equals(seats_booked.get(i))) {
                    C4.setImageResource(R.drawable.seat3);
                    select_C4=1;
                } else if ("C5".equals(seats_booked.get(i))) {
                    C5.setImageResource(R.drawable.seat3);
                    select_C5=1;
                } else if ("C6".equals(seats_booked.get(i))) {
                    C6.setImageResource(R.drawable.seat3);
                    select_C6=1;
                } else if ("C7".equals(seats_booked.get(i))) {
                    C7.setImageResource(R.drawable.seat3);
                    select_C7=1;
                } else if ("D1".equals(seats_booked.get(i))) {
                    D1.setImageResource(R.drawable.seat3);
                    select_D1=1;
                } else if ("D2".equals(seats_booked.get(i))) {
                    D2.setImageResource(R.drawable.seat3);
                    select_D2=1;
                } else if ("D3".equals(seats_booked.get(i))) {
                    D3.setImageResource(R.drawable.seat3);
                    select_D3=1;
                } else if ("D4".equals(seats_booked.get(i))) {
                    D4.setImageResource(R.drawable.seat3);
                    select_D4=1;
                }
                else if ("D5".equals(seats_booked.get(i))) {
                    D5.setImageResource(R.drawable.seat3);
                    select_D5=1;
                }else if ("D6".equals(seats_booked.get(i))) {
                    D6.setImageResource(R.drawable.seat3);
                    select_D6=1;
                }else if ("D7".equals(seats_booked.get(i))) {
                    D7.setImageResource(R.drawable.seat3);
                    select_D7=1;
                }
            }
            // }
        }
        else
        {
            System.out.print("no print");
        }


        A1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String mDrawableName = "seat1";
                int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());

                Integer resource = (Integer) A1.getTag();

                System.out.println("The resource is:"+ resource );


                if(select_A1==0){
                    System.out.println("I am in selected seat");
                    A1.setImageResource(R.drawable.seat2);
                    select_A1=2;
                    System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("A1");

                }

                else if(select_A1==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_A1==2){
                    System.out.println("This seat is unselected");
                    A1.setImageResource(R.drawable.seat1);
                    select_A1=0;

                    seats_counter--;
                    arrayList.remove("A1");
                }
            }
        });


        A2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String mDrawableName = "seat1";
                int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());

                Integer resource = (Integer) A1.getTag();

                System.out.println("The resource is:"+ resource );


                if(select_A2==0){
                    System.out.println("I am in selected seat");
                    A2.setImageResource(R.drawable.seat2);
                    select_A2=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("A2");

                }

                else if(select_A2==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_A2==2){
                    System.out.println("This seat is unselected");
                    A2.setImageResource(R.drawable.seat1);
                    select_A2=0;

                    seats_counter--;
                    arrayList.remove("A2");
                }
            }
        });



        A3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String mDrawableName = "seat1";
                int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());

                Integer resource = (Integer) A1.getTag();

                System.out.println("The resource is:"+ resource );


                if(select_A3==0){
                    System.out.println("I am in selected seat");
                    A3.setImageResource(R.drawable.seat2);
                    select_A3=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("A3");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_A3==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_A3==2){
                    System.out.println("This seat is unselected");
                    A3.setImageResource(R.drawable.seat1);
                    select_A3=0;
                    seats_counter--;
                    arrayList.remove("A3");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        A4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_A4==0){
                    System.out.println("I am in selected seat");
                    A4.setImageResource(R.drawable.seat2);
                    select_A4=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("A4");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_A4==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_A4==2){
                    System.out.println("This seat is unselected");
                    A4.setImageResource(R.drawable.seat1);
                    select_A4=0;
                    seats_counter--;
                    arrayList.remove("A4");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        A5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_A5==0){
                    System.out.println("I am in selected seat");
                    A5.setImageResource(R.drawable.seat2);
                    select_A5=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("A5");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_A5==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_A5==2){
                    System.out.println("This seat is unselected");
                    A5.setImageResource(R.drawable.seat1);
                    select_A5=0;
                    seats_counter--;
                    arrayList.remove("A5");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });


        A6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_A6==0){
                    System.out.println("I am in selected seat");
                    A6.setImageResource(R.drawable.seat2);
                    select_A6=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("A6");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_A6==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_A6==2){
                    System.out.println("This seat is unselected");
                    A6.setImageResource(R.drawable.seat1);
                    select_A6=0;
                    seats_counter--;
                    arrayList.remove("A6");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });


        A7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_A7==0){
                    System.out.println("I am in selected seat");
                    A7.setImageResource(R.drawable.seat2);
                    select_A7=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("A7");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_A7==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_A7==2){
                    System.out.println("This seat is unselected");
                    A7.setImageResource(R.drawable.seat1);
                    select_A7=0;
                    seats_counter--;
                    arrayList.remove("A7");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        A7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_A7==0){
                    System.out.println("I am in selected seat");
                    A7.setImageResource(R.drawable.seat2);
                    select_A7=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("A7");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_A7==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_A7==2){
                    System.out.println("This seat is unselected");
                    A7.setImageResource(R.drawable.seat1);
                    select_A7=0;
                    seats_counter--;
                    arrayList.remove("A7");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        A7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_A7==0){
                    System.out.println("I am in selected seat");
                    A7.setImageResource(R.drawable.seat2);
                    select_A7=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("A7");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_A7==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_A7==2){
                    System.out.println("This seat is unselected");
                    A7.setImageResource(R.drawable.seat1);
                    select_A7=0;
                    seats_counter--;
                    arrayList.remove("A7");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });


        B1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_B1==0){
                    System.out.println("I am in selected seat");
                    B1.setImageResource(R.drawable.seat2);
                    select_B1=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("B1");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_B1==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_B1==2){
                    System.out.println("This seat is unselected");
                    B1.setImageResource(R.drawable.seat1);
                    select_B1=0;
                    seats_counter--;
                    arrayList.remove("B1");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });


        B2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_B2==0){
                    System.out.println("I am in selected seat");
                    B2.setImageResource(R.drawable.seat2);
                    select_B2=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("B2");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_B2==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_B2==2){
                    System.out.println("This seat is unselected");
                    B2.setImageResource(R.drawable.seat1);
                    select_B2=0;
                    seats_counter--;
                    arrayList.remove("B2");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        B3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_B3==0){
                    System.out.println("I am in selected seat");
                    B3.setImageResource(R.drawable.seat2);
                    select_B3=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("B3");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_B3==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_B3==2){
                    System.out.println("This seat is unselected");
                    B3.setImageResource(R.drawable.seat1);
                    select_B3=0;
                    seats_counter--;
                    arrayList.remove("B3");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        B4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_B4==0){
                    System.out.println("I am in selected seat");
                    B4.setImageResource(R.drawable.seat2);
                    select_B4=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("B4");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_B4==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_B4==2){
                    System.out.println("This seat is unselected");
                    B4.setImageResource(R.drawable.seat1);
                    select_B4=0;
                    seats_counter--;
                    arrayList.remove("B4");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        B5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_B5==0){
                    System.out.println("I am in selected seat");
                    B5.setImageResource(R.drawable.seat2);
                    select_B5=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("B5");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_B5==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_B5==2){
                    System.out.println("This seat is unselected");
                    B5.setImageResource(R.drawable.seat1);
                    select_B5=0;
                    seats_counter--;
                    arrayList.remove("B5");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        B6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_B6==0){
                    System.out.println("I am in selected seat");
                    B6.setImageResource(R.drawable.seat2);
                    select_B6=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("B6");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_B6==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_B6==2){
                    System.out.println("This seat is unselected");
                    B6.setImageResource(R.drawable.seat1);
                    select_B6=0;
                    seats_counter--;
                    arrayList.remove("B6");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        B7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_B7==0){
                    System.out.println("I am in selected seat");
                    B7.setImageResource(R.drawable.seat2);
                    select_B7=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("B7");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_B7==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_B7==2){
                    System.out.println("This seat is unselected");
                    B7.setImageResource(R.drawable.seat1);
                    select_B7=0;
                    seats_counter--;
                    arrayList.remove("B7");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        C1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_C1==0){
                    System.out.println("I am in selected seat");
                    C1.setImageResource(R.drawable.seat2);
                    select_C1=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("C1");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_C1==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_C1==2){
                    System.out.println("This seat is unselected");
                    C1.setImageResource(R.drawable.seat1);
                    select_C1=0;
                    seats_counter--;
                    arrayList.remove("C1");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        C1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_C1==0){
                    System.out.println("I am in selected seat");
                    C1.setImageResource(R.drawable.seat2);
                    select_C1=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("C1");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_C1==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_C1==2){
                    System.out.println("This seat is unselected");
                    C1.setImageResource(R.drawable.seat1);
                    select_C1=0;
                    seats_counter--;
                    arrayList.remove("C1");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });


        C2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_C2==0){
                    System.out.println("I am in selected seat");
                    C2.setImageResource(R.drawable.seat2);
                    select_C2=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("C2");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_C2==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_C2==2){
                    System.out.println("This seat is unselected");
                    C2.setImageResource(R.drawable.seat1);
                    select_C2=0;
                    seats_counter--;
                    arrayList.remove("C2");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });


        C3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_C3==0){
                    System.out.println("I am in selected seat");
                    C3.setImageResource(R.drawable.seat2);
                    select_C3=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("C3");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_C3==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_C3==2){
                    System.out.println("This seat is unselected");
                    C3.setImageResource(R.drawable.seat1);
                    select_C3=0;
                    seats_counter--;
                    arrayList.remove("C3");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });



        C4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_C4==0){
                    System.out.println("I am in selected seat");
                    C4.setImageResource(R.drawable.seat2);
                    select_C4=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("C4");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_C4==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_C4==2){
                    System.out.println("This seat is unselected");
                    C4.setImageResource(R.drawable.seat1);
                    select_C4=0;
                    seats_counter--;
                    arrayList.remove("C4");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });


        C5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_C5==0){
                    System.out.println("I am in selected seat");
                    C5.setImageResource(R.drawable.seat2);
                    select_C5=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("C5");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_C5==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_C5==2){
                    System.out.println("This seat is unselected");
                    C5.setImageResource(R.drawable.seat1);
                    select_C5=0;
                    seats_counter--;
                    arrayList.remove("C5");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        C6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_C6==0){
                    System.out.println("I am in selected seat");
                    C6.setImageResource(R.drawable.seat2);
                    select_C6=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("C6");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_C6==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_C6==2){
                    System.out.println("This seat is unselected");
                    C6.setImageResource(R.drawable.seat1);
                    select_C6=0;
                    seats_counter--;
                    arrayList.remove("C6");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        C7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_C7==0){
                    System.out.println("I am in selected seat");
                    C7.setImageResource(R.drawable.seat2);
                    select_C7=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("C7");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_C7==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_C7==2){
                    System.out.println("This seat is unselected");
                    C7.setImageResource(R.drawable.seat1);
                    select_C7=0;
                    seats_counter--;
                    arrayList.remove("C7");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        D1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_D1==0){
                    System.out.println("I am in selected seat");
                    D1.setImageResource(R.drawable.seat2);
                    select_D1=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("D1");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_D1==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_D1==2){
                    System.out.println("This seat is unselected");
                    D1.setImageResource(R.drawable.seat1);
                    select_D1=0;
                    seats_counter--;
                    arrayList.remove("D1");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        D2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_D2==0){
                    System.out.println("I am in selected seat");
                    D2.setImageResource(R.drawable.seat2);
                    select_D2=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("D2");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_D2==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_D2==2){
                    System.out.println("This seat is unselected");
                    D2.setImageResource(R.drawable.seat1);
                    select_D2=0;
                    seats_counter--;
                    arrayList.remove("D2");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        D3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_D3==0){
                    System.out.println("I am in selected seat");
                    D3.setImageResource(R.drawable.seat2);
                    select_D3=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("D3");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_D3==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_D3==2){
                    System.out.println("This seat is unselected");
                    D3.setImageResource(R.drawable.seat1);
                    select_D3=0;
                    seats_counter--;
                    arrayList.remove("D3");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        D4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_D4==0){
                    System.out.println("I am in selected seat");
                    D4.setImageResource(R.drawable.seat2);
                    select_D4=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("D4");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_D4==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_D4==2){
                    System.out.println("This seat is unselected");
                    D4.setImageResource(R.drawable.seat1);
                    select_D4=0;
                    seats_counter--;
                    arrayList.remove("D4");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        D5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_D5==0){
                    System.out.println("I am in selected seat");
                    D5.setImageResource(R.drawable.seat2);
                    select_D5=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("D5");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_D5==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_D5==2){
                    System.out.println("This seat is unselected");
                    D5.setImageResource(R.drawable.seat1);
                    select_D5=0;
                    seats_counter--;
                    arrayList.remove("D5");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        D6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_D6==0){
                    System.out.println("I am in selected seat");
                    D6.setImageResource(R.drawable.seat2);
                    select_D6=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("D6");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_D6==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_D6==2){
                    System.out.println("This seat is unselected");
                    D6.setImageResource(R.drawable.seat1);
                    select_D6=0;
                    seats_counter--;
                    arrayList.remove("D6");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

        D7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(select_D7==0){
                    System.out.println("I am in selected seat");
                    D7.setImageResource(R.drawable.seat2);
                    select_D7=2;
                    //   System.out.println("The select is:"+ select_A1 );
                    seats_counter++;
                    arrayList.add("D7");
                    System.out.println("Array list value:"+arrayList);

                }

                else if(select_D7==1){
                    System.out.println("This seat is already booked");
                    Toast toast1= Toast.makeText(getApplicationContext(),"Sorry, this seat is already booked.",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                else if(select_D7==2){
                    System.out.println("This seat is unselected");
                    D7.setImageResource(R.drawable.seat1);
                    select_D7=0;
                    seats_counter--;
                    arrayList.remove("D7");
                    System.out.println("Array list value:"+arrayList);
                }
            }
        });

    }



    public void counter(){

        int size ;

        if(flag==0){
            temp= Integer.toString(seats_counter);
            arrayList1.add(temp);
            outer.add(arrayList1);
            flag=1;
        }
        else{
            size = arrayList1.size();
            String get_currval = arrayList1.get(size-1);
            arrayList1.remove(get_currval);
            temp= Integer.toString(seats_counter);
            arrayList1.add(temp);
            outer.add(arrayList1);
            //   System.out.println("Seat Count value changed:"+ temp);




        }
    }

    public void seat_information(View V){

        Intent intent;
        outer.clear();
        outer.add(arrayList);
        counter();

        if(seats_counter!= 0){
            bundle = new Bundle();

            bundle.putStringArrayList("seats",arrayList);
            bundle.putStringArrayList("total", arrayList1);
            System.out.println("The arraylist items are :"+ outer);
            System.out.println("The movie is : "+ movie);
            System.out.println("The date is: "+ date);

            intent = new Intent(SeatSelection.this,Confirmation.class);
            intent.putExtra("seat_information",bundle);
            intent.putExtra("movie_id", Integer.toString(movie));
            intent.putExtra("date", date);
            intent.putExtra("theatre", theatre);
            intent.putExtra("time", time);
            startActivity(intent);
        }
        else{
            Toast toast= Toast.makeText(getApplicationContext(),"Please select a seat to proceed",Toast.LENGTH_LONG);
            toast.show();
        }


    }


}
