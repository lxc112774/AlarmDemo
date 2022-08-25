package com.example.lxc.alarmdemo;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;

import java.util.Calendar;

//闹钟唤醒休眠，执行功能
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent = new Intent(MainActivity.this, OneShotAlarm.class);
//        intent.setAction("short");  //为Intent设置动作 ，调用android操作系统一些自带的功能
//        PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);

        Intent intent = new Intent(this, Activity2.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);

        //设定一个五秒后的时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 5);

        int anHour = 5 * 1000; //5s
        long triggerAtTime = System.currentTimeMillis() + anHour;

        AlarmManager alarm = (AlarmManager)getSystemService(ALARM_SERVICE);
        //AlarmManager.RTC_WAKEUP：在手机睡眠状态也下会唤醒系统并执行提示功能，该状态下闹钟使用绝对时间; 和System.currentTimeMillis()配对使用
        //AlarmManager.ELAPSED_REALTIME_WAKEUP:在手机睡眠状态也下会唤醒系统并执行提示功能，该状态下使用开机相对时间; 和SystemClock.elapsedRealtime()配对使用
        // pi为延迟打开intent，即满足条件就开启
        alarm.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
        //alarm.set(AlarmManager.RTC_WAKEUP, triggerAtTime, pi);
        //alarm.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 5 * 1000, pi);

    }
}
