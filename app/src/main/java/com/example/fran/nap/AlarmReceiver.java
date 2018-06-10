package com.example.fran.nap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.widget.Toast;

import static android.support.v4.content.WakefulBroadcastReceiver.startWakefulService;

/**
 * Created by Fran on 17.04.2018.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "asdadad", Toast.LENGTH_SHORT).show();

        Intent service = new Intent(context, AlarmIntentService.class);
        startWakefulService(context, service);
    }
}
