package com.example.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

public class MyReceiver extends BroadcastReceiver {
 ImageView img1;
    public MyReceiver(ImageView img) {
        this.img1=img;

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
       switch (intent.getAction()){
           case Intent.ACTION_POWER_CONNECTED:
               img1.setImageResource(R.drawable.fullimages);
               break;
           case Intent.ACTION_POWER_DISCONNECTED:
               img1.setImageResource(R.drawable.empty);
               break;
       }


    }
}
