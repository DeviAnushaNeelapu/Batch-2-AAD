package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    MyReceiver rv;

    PendingIntent pi;
    NotificationManager notificationManager;
    private static final String PRIMARY_CHANNEL_ID="PRIMARY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.android);
        rv=new MyReceiver(img);
        IntentFilter i = new IntentFilter();
        i.addAction(Intent.ACTION_POWER_CONNECTED);
        i.addAction(Intent.ACTION_POWER_DISCONNECTED);
        this.registerReceiver(rv,i);
        Intent  i2 = new Intent(this,MainActivity.class);
        pi= PendingIntent.getActivity(this,1234,i2,PendingIntent.FLAG_UPDATE_CURRENT);

        createNofitificationChannel();
    }

    private void createNofitificationChannel() {
        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
            NotificationChannel notificationChannel= new NotificationChannel(PRIMARY_CHANNEL_ID,"anusha",NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setLightColor(Color.BLUE);
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);


        }
    }


    public void notifications(View view) {
        //NotificationCompat.Builder builder=new NotificationCompat.Builder(this,PRIMARY_CHANNEL_ID);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID);
               builder .setContentTitle("hi nitya!");
               builder .setContentText("no no.");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setDefaults(Notification.DEFAULT_ALL);
                builder.setContentIntent(pi);
                notificationManager.notify(124,builder.build());
    }
}
