package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public static final String MYCUSTOMRECIEVER="broad";
 ImageView img;
 CustomReceiver cu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.empty);
        cu=new CustomReceiver(img);
        IntentFilter i = new IntentFilter();
        i.addAction(Intent.ACTION_POWER_CONNECTED);
        i.addAction(Intent.ACTION_POWER_DISCONNECTED);
        i.addAction(MYCUSTOMRECIEVER);
        this.registerReceiver(cu,i);
        // Register the receiver to receive custom broadcast.
        LocalBroadcastManager.getInstance(this).registerReceiver
                (cu, new IntentFilter(MYCUSTOMRECIEVER));
    }

    /**
     * Click event handler for the button, that sends custom broadcast using the
     * LocalBroadcastManager.
     */


    public void click(View view) {
        Intent customBroadcastIntent = new Intent(MYCUSTOMRECIEVER);
       // After the custom Intent declaration, send the broadcast using the LocalBroadcastManager class:
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);


    }
    @Override
    protected void onDestroy() {
        // Unregister the receivers.
        this.unregisterReceiver(cu);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(cu);
        super.onDestroy();
    }
}
