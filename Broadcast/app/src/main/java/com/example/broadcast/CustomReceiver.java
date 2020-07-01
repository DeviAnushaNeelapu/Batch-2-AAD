package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
 ImageView img1;
    public CustomReceiver(ImageView img) {
        this.img1=img;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "powerconnected", Toast.LENGTH_SHORT).show();
                img1.setImageResource(R.drawable.fullimages);
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Toast.makeText(context, "powerdisconneted.", Toast.LENGTH_SHORT).show();
                img1.setImageResource(R.drawable.empty);
                break;
            case MainActivity.MYCUSTOMRECIEVER:
                Toast.makeText(context, "custom broadcasted", Toast.LENGTH_SHORT).show();
                img1.setImageResource(R.drawable.ic_launcher_background);
                break;
        }

    }
}
