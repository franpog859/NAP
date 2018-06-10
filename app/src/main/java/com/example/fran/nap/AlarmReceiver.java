package com.example.fran.nap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.widget.Toast;

import static android.content.Context.POWER_SERVICE;
import static android.support.v4.content.WakefulBroadcastReceiver.startWakefulService;

/**
 * Created by Fran on 17.04.2018.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "asdadad", Toast.LENGTH_SHORT).show();

        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(400);

        PowerManager powerManager = (PowerManager) context.getApplicationContext()
                .getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wakeLock = powerManager.newWakeLock(
                (PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP),
                "TAG");
        wakeLock.acquire();

        //Intent service = new Intent(context, AlarmIntentService.class);
        //startWakefulService(context, service);
    }
}
