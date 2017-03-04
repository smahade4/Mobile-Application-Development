package com.cs442.dsuraj.quantumc;


import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.location.Location;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import layout.GPlusFragment;

public class Theatre extends AppCompatActivity {
    public int dist;
    public int distance1;
    TextView amcdist;
    TextView regaldist;
    TextView landmark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theatre);

        Bundle b = getIntent().getExtras();
        final int movie = b.getInt("movie_id");
        final String dated = b.getString("date");
        //Date today = new Date();
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String rq = formatter.format(new Date()).toString();
        Date startDate = null;
        Date today = null;
        try {
            startDate = formatter.parse(dated);
            today = formatter.parse(rq);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Button a1 = (Button) findViewById(R.id.button9);
        Button AMC2 = (Button) findViewById(R.id.AMC2);
        Button AMC3 = (Button) findViewById(R.id.AMC3);
        Button AMC4 = (Button) findViewById(R.id.AMC4);
        Button AMC5 = (Button) findViewById(R.id.AMC5);

        Button RC1 = (Button) findViewById(R.id.RC1);
        Button RC2 = (Button) findViewById(R.id.RC2);
        Button RC3 = (Button) findViewById(R.id.RC3);
        Button RC4 = (Button) findViewById(R.id.RC4);

        Button LMC1 = (Button) findViewById(R.id.LMC1);
        Button LMC2 = (Button) findViewById(R.id.LMC2);
        Button LMC3 = (Button) findViewById(R.id.LMC3);
        Button LMC4 = (Button) findViewById(R.id.LMC4);
        Button LMC5 = (Button) findViewById(R.id.LMC5);

        amcdist = (TextView) findViewById(R.id.amcdist);
        regaldist = (TextView) findViewById(R.id.regaldist);
        landmark = (TextView) findViewById(R.id.landmarkdist);

        distance1 = distance(41.891000, -87.620100);
        if (distance1 == 0) {
            Toast.makeText(getApplicationContext(), "Please Switch on GPS to find the Theatre Distance", Toast.LENGTH_SHORT).show();
            amcdist.setText(Integer.toString(distance1) + " mi");
            distance1 = distance(41.751352, -87.583533);
            regaldist.setText(Integer.toString(distance1) + " mi");
            distance1 = distance(41.933400, -87.645600);
            landmark.setText(Integer.toString(distance1) + " mi");
            final SwipeRefreshLayout swipe = (SwipeRefreshLayout) findViewById(R.id.activity_theatre);
            swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    swipe.setRefreshing(true);
                    (new Handler()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            swipe.setRefreshing(false);
                            distance1 = distance(41.891000, -87.620100);
                            amcdist.setText(Integer.toString(distance1) + " mi");
                            distance1 = distance(41.751352, -87.583533);
                            regaldist.setText(Integer.toString(distance1) + " mi");
                            distance1 = distance(41.933400, -87.645600);
                            landmark.setText(Integer.toString(distance1) + " mi");
                        }
                    }, 2000);
                }
            });
        } else {
            amcdist.setText(Integer.toString(distance1) + " mi");
            distance1 = distance(41.751352, -87.583533);
            regaldist.setText(Integer.toString(distance1) + " mi");
            distance1 = distance(41.933400, -87.645600);
            landmark.setText(Integer.toString(distance1) + " mi");
        }

        DateFormat df = new SimpleDateFormat("HH:mm");
        String data = df.format(new Date());

        Date showTime = null;
        Date showTime1 = null;
        Date showTime2 = null;
        Date showTime3 = null;
        Date showTime4 = null;
        Date showTime5 = null;
        Date showTime6 = null;
        Date showTime7 = null;
        Date showTime8 = null;
        Date showTime9 = null;
        Date showTime10 = null;
        Date showTime11 = null;
        Date showTime12 = null;
        Date showTime13 = null;
        Date compare2 = null;

        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        try {
            showTime = time.parse("11:00");
            showTime1 = time.parse("14:15");
            showTime2 = time.parse("17:30");
            showTime3 = time.parse("19:15");
            showTime4 = time.parse("21:15");
            showTime5 = time.parse("12:05");
            showTime6 = time.parse("16:15");
            showTime7 = time.parse("19:05");
            showTime8 = time.parse("21:15");
            showTime9 = time.parse("11:30");
            showTime10 = time.parse("14:45");
            showTime11 = time.parse("16:30");
            showTime12 = time.parse("19:05");
            showTime13 = time.parse("21:15");


            compare2 = time.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int dif = (int) (showTime.getTime() - compare2.getTime());
        int dif1 = (int) (showTime1.getTime() - compare2.getTime());
        int dif2 = (int) (showTime2.getTime() - compare2.getTime());
        int dif3 = (int) (showTime3.getTime() - compare2.getTime());
        int dif4 = (int) (showTime4.getTime() - compare2.getTime());
        int dif5 = (int) (showTime5.getTime() - compare2.getTime());
        int dif6 = (int) (showTime6.getTime() - compare2.getTime());
        int dif7 = (int) (showTime7.getTime() - compare2.getTime());
        int dif8 = (int) (showTime8.getTime() - compare2.getTime());
        int dif9 = (int) (showTime9.getTime() - compare2.getTime());
        int dif10 = (int) (showTime10.getTime() - compare2.getTime());
        int dif11 = (int) (showTime11.getTime() - compare2.getTime());
        int dif12 = (int) (showTime12.getTime() - compare2.getTime());
        int dif13 = (int) (showTime13.getTime() - compare2.getTime());


        if (today.equals(startDate) && dif < 0) {

            a1.setEnabled(false);

        } else {
            a1.setEnabled(true);
        } //////////

        if (today.equals(startDate) && dif1 < 0) {

            AMC2.setEnabled(false);

        } else {
            AMC2.setEnabled(true);
        } ///////////

        if (today.equals(startDate) && dif2 < 0) {

            AMC3.setEnabled(false);

        } else {
            AMC3.setEnabled(true);
        } /////////

        if (today.equals(startDate) && dif3 < 0) {

            AMC4.setEnabled(false);

        } else {
            AMC4.setEnabled(true);
        }

        if (today.equals(startDate) && dif4 < 0) {

            AMC5.setEnabled(false);

        } else {
            AMC5.setEnabled(true);
        }

        if (today.equals(startDate) && dif5 < 0) {

            RC1.setEnabled(false);

        } else {
            RC1.setEnabled(true);
        }

        if (today.equals(startDate) && dif6 < 0) {

            RC2.setEnabled(false);

        } else {
            RC2.setEnabled(true);
        }

        if (today.equals(startDate) && dif7 < 0) {

            RC3.setEnabled(false);

        } else {
            RC3.setEnabled(true);
        }

        if (today.equals(startDate) && dif8 < 0) {

            RC4.setEnabled(false);

        } else {
            RC4.setEnabled(true);
        }

        if (today.equals(startDate) && dif9 < 0) {

            LMC1.setEnabled(false);

        } else {
            LMC1.setEnabled(true);
        }

        if (today.equals(startDate) && dif10 < 0) {

            LMC2.setEnabled(false);

        } else {
            LMC2.setEnabled(true);
        }

        if (today.equals(startDate) && dif11 < 0) {

            LMC3.setEnabled(false);

        } else {
            LMC3.setEnabled(true);
        }

        if (today.equals(startDate) && dif12 < 0) {

            LMC4.setEnabled(false);

        } else {
            LMC4.setEnabled(true);
        }

        if (today.equals(startDate) && dif13 < 0) {

            LMC5.setEnabled(false);

        } else {
            LMC5.setEnabled(true);
        }



            if (a1.isEnabled()) {

                a1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GPlusFragment.flag == 1) {

                            Intent intent = new Intent(Theatre.this, SeatSelection.class);
                            intent.putExtra("movie_id", movie);
                            intent.putExtra("date", dated);
                            intent.putExtra("theatre", "AMC");
                            intent.putExtra("time", "11:00 AM");
                            startActivity(intent);

                        } else {
                            Toast.makeText(getApplicationContext(), "Please Sign In Before Selecting Seats", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }


            if (AMC2.isEnabled()) {

                AMC2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GPlusFragment.flag == 1) {
                            Intent intent = new Intent(Theatre.this, SeatSelection.class);
                            intent.putExtra("movie_id", movie);
                            intent.putExtra("date", dated);
                            intent.putExtra("theatre", "AMC");
                            intent.putExtra("time", "02:15 PM");
                            startActivity(intent);

                        } else {
                            Toast.makeText(getApplicationContext(), "Please Sign In Before Selecting Seats", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            if (AMC3.isEnabled()) {

                AMC3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GPlusFragment.flag == 1) {
                            Intent intent = new Intent(Theatre.this, SeatSelection.class);
                            intent.putExtra("movie_id", movie);
                            intent.putExtra("date", dated);
                            intent.putExtra("theatre", "AMC");
                            intent.putExtra("time", "05:30 PM");
                            startActivity(intent);

                        } else {
                            Toast.makeText(getApplicationContext(), "Please Sign In Before Selecting Seats", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            if (AMC4.isEnabled()) {

                AMC4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GPlusFragment.flag == 1) {
                        Intent intent = new Intent(Theatre.this, SeatSelection.class);
                        intent.putExtra("movie_id", movie);
                        intent.putExtra("date", dated);
                        intent.putExtra("theatre", "AMC");
                        intent.putExtra("time", "07:15 PM");
                        startActivity(intent);

                    }
                        else {
                            Toast.makeText(getApplicationContext(), "Please Sign In Before Selecting Seats", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            if (AMC5.isEnabled()) {

                AMC5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GPlusFragment.flag == 1) {
                        Intent intent = new Intent(Theatre.this, SeatSelection.class);
                        intent.putExtra("movie_id", movie);
                        intent.putExtra("date", dated);
                        intent.putExtra("theatre", "AMC");
                        intent.putExtra("time", "09:15 PM");
                        startActivity(intent);

                    }
                        else {
                            Toast.makeText(getApplicationContext(), "Please Sign In Before Selecting Seats", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            if (RC1.isEnabled()) {

                RC1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GPlusFragment.flag == 1) {
                        Intent intent = new Intent(Theatre.this, SeatSelection.class);
                        intent.putExtra("movie_id", movie);
                        intent.putExtra("date", dated);
                        intent.putExtra("theatre", "Regal Cinemas");
                        intent.putExtra("time", "12:05 PM");
                        startActivity(intent);

                    }
                        else {
                            Toast.makeText(getApplicationContext(), "Please Sign In Before Selecting Seats", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            if (RC2.isEnabled()) {

                RC2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GPlusFragment.flag == 1) {
                        Intent intent = new Intent(Theatre.this, SeatSelection.class);
                        intent.putExtra("movie_id", movie);
                        intent.putExtra("date", dated);
                        intent.putExtra("theatre", "Regal Cinemas");
                        intent.putExtra("time", "04:15 PM");
                        startActivity(intent);

                    }
                        else {
                            Toast.makeText(getApplicationContext(), "Please Sign In Before Selecting Seats", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            if (RC3.isEnabled()) {

                RC3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GPlusFragment.flag == 1) {
                        Intent intent = new Intent(Theatre.this, SeatSelection.class);
                        intent.putExtra("movie_id", movie);
                        intent.putExtra("date", dated);
                        intent.putExtra("theatre", "Regal Cinemas");
                        intent.putExtra("time", "07:05 PM");
                        startActivity(intent);

                    }
                        else {
                            Toast.makeText(getApplicationContext(), "Please Sign In Before Selecting Seats", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            if (RC4.isEnabled()) {

                RC4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GPlusFragment.flag == 1) {
                        Intent intent = new Intent(Theatre.this, SeatSelection.class);
                        intent.putExtra("movie_id", movie);
                        intent.putExtra("date", dated);
                        intent.putExtra("theatre", "Regal Cinemas");
                        intent.putExtra("time", "19:15 PM");
                        startActivity(intent);

                    }
                        else {
                            Toast.makeText(getApplicationContext(), "Please Sign In Before Selecting Seats", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            if (LMC1.isEnabled()) {

                LMC1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GPlusFragment.flag == 1) {
                        Intent intent = new Intent(Theatre.this, SeatSelection.class);
                        intent.putExtra("movie_id", movie);
                        intent.putExtra("date", dated);
                        intent.putExtra("theatre", "Land Mark");
                        intent.putExtra("time", "11:30 AM");
                        startActivity(intent);

                    }
                        else {
                            Toast.makeText(getApplicationContext(), "Please Sign In Before Selecting Seats", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            if (LMC2.isEnabled()) {

                LMC2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GPlusFragment.flag == 1) {
                        Intent intent = new Intent(Theatre.this, SeatSelection.class);
                        intent.putExtra("movie_id", movie);
                        intent.putExtra("date", dated);
                        intent.putExtra("theatre", "Land Mark");
                        intent.putExtra("time", "02:45 PM");
                        startActivity(intent);

                    }
                        else {
                            Toast.makeText(getApplicationContext(), "Please Sign In Before Selecting Seats", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            if (LMC3.isEnabled()) {

                LMC3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GPlusFragment.flag == 1) {
                        Intent intent = new Intent(Theatre.this, SeatSelection.class);
                        intent.putExtra("movie_id", movie);
                        intent.putExtra("date", dated);
                        intent.putExtra("theatre", "Land Mark");
                        intent.putExtra("time", "04:30 PM");
                        startActivity(intent);

                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Please Sign In Before Selecting Seats", Toast.LENGTH_SHORT).show();
                    }
                }
                });
            }

            if (LMC4.isEnabled()) {

                LMC4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GPlusFragment.flag == 1) {
                        Intent intent = new Intent(Theatre.this, SeatSelection.class);
                        intent.putExtra("movie_id", movie);
                        intent.putExtra("date", dated);
                        intent.putExtra("theatre", "Land Mark");
                        intent.putExtra("time", "07:05 PM");
                        startActivity(intent);

                    }
                        else {
                            Toast.makeText(getApplicationContext(), "Please Sign In Before Selecting Seats", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            if (LMC5.isEnabled()) {

                LMC5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GPlusFragment.flag == 1) {
                        Intent intent = new Intent(Theatre.this, SeatSelection.class);
                        intent.putExtra("movie_id", movie);
                        intent.putExtra("date", dated);
                        intent.putExtra("theatre", "Land Mark");
                        intent.putExtra("time", "09:15 PM");
                        startActivity(intent);

                    }
                        else {
                            Toast.makeText(getApplicationContext(), "Please Sign In Before Selecting Seats", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
    }
    public int distance(double latitude, double longitude) {
        GPSTracker gps = new GPSTracker(this);

        if (gps.canGetLocation()) { // gps enabled} // return boolean true/false
            double lat2 = gps.getLatitude(); // returns latitude
            double lng2 = gps.getLongitude(); // returns longitude
            gps.stopUsingGPS();

            double earthRadius = 3958.75;
            double dLat = Math.toRadians(latitude - lat2);
            double dLng = Math.toRadians(longitude - lng2);
            double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                    Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(latitude)) *
                            Math.sin(dLng / 2) * Math.sin(dLng / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            dist = (int) (earthRadius * c);

        }
        return dist;
    }

}
