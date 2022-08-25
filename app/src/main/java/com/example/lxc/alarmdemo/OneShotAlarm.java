package com.example.lxc.alarmdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by lxc on 17-9-29.
 */
//闹钟广播
public class OneShotAlarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
// TODO Auto-generated method stub
        if(intent.getAction().equals("short")){
            Toast.makeText(context, "short alarm", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context, "repeating alarm",Toast.LENGTH_LONG).show();
        }
    }
}