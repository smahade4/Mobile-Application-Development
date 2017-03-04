package com.cs442.smahade4.assignment6;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by sushmama on 10/22/2016.
 */
public class ServiceClass extends Service{
    Timer timer;
    int count;
    int timercount=0;
    NotificationManager manager;

    @Override
    public void onCreate() {
        Log.i("smahade4","Service Created Current Counter "+count);
        // create timer object
        timer=new Timer();
    }

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // get the edit text counter value from main activity
        count = intent.getIntExtra("counter",1);
        // set timer and run at fix time
        timer.scheduleAtFixedRate(new MyTimer(),1000, 1000);
        Log.i("smahade4","Service OnStart Current Counter "+count);

        return Service.START_NOT_STICKY;

    }

   public class MyTimer extends TimerTask
   {



       @Override
       public void run() {
           //timercount counter for 10 sec notification
           timercount++;
           // count variable that increments every 1 sec  and displays in notification
           // if edittext number is set count will increment 1 sec from that number
           count++;

           if(timercount==10)
           {
               Log.i("smahade4","Notification Current Counter "+count);
               showNotification(count-1);
               timercount=0;
           }
       }

   }

    private void showNotification(int count) {

        // Display the notification sound and vibration every 10sec

        int NOTIFICATION_ID = 1;
        // Get the intent for notificaton
        Intent notificationIntent = new Intent(this, NotificationDetails.class);
        notificationIntent.putExtra("count",String.valueOf(count));
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);

        // Set the notification details sound and vibration
        notificationBuilder.setSmallIcon(R.drawable.notimg)
                        .setContentTitle("Message")
                        .setContentText("Counter value:" + count)
                        .setDefaults(Notification.DEFAULT_SOUND |Notification.DEFAULT_VIBRATE );

        //set the intent for notification
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,  PendingIntent.FLAG_UPDATE_CURRENT);
        notificationBuilder.setContentIntent(contentIntent);

        // get the notification manager and notify start the notification
       manager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID, notificationBuilder.build());

    }
    @Override
    public void onDestroy() {
        // on destroy of service the service will be destroyed and notification will be cancelled
        // will be called when the user clicks stop service button
        super.onDestroy();
        timer.cancel();
        manager = ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE));
        manager.cancel(1);
        Log.i("smahade4","Service Destroyed Current Counter "+count);
    }
}
