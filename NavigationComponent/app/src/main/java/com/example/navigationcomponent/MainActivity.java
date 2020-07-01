package com.example.navigationcomponent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Notification;



//    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
  //  private NotificationManager mNotifyManager;
    //private static final int NOTIFICATION_ID = 0;

    public class MainActivity extends AppCompatActivity {
        NotificationManager mNotifyManager;
        private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
        PendingIntent pendingIntent;
        Intent intent;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //it is default system service
            createNotificationChannel();
            intent = new Intent(this, MainActivity.class);
            pendingIntent = PendingIntent.getActivity(this, 25365, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        }

        private NotificationCompat.Builder getNotificationBuilder() {
            NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                    .setContentTitle("hi nitya!")
                    .setContentText("no no.")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentIntent(pendingIntent);
            return notifyBuilder;
        }

        public void createNotificationChannel() {
            mNotifyManager = (NotificationManager)
                    getSystemService(NOTIFICATION_SERVICE);
            if (android.os.Build.VERSION.SDK_INT >=
                    android.os.Build.VERSION_CODES.O) {
                // Create a NotificationChannel
                NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                        "Mascot Notification", NotificationManager
                        .IMPORTANCE_HIGH);
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(Color.RED);
                notificationChannel.enableVibration(true);
                notificationChannel.setDescription("Notification from Mascot");
                mNotifyManager.createNotificationChannel(notificationChannel);
            }
        }

        public void sendNotification(View view) {
            NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
            mNotifyManager.notify(675, notifyBuilder.build());
        }
    }
