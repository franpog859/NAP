package com.example.fran.nap;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

/**
 * Created by Fran on 21.06.2018.
 */

public class AlarmService {

    private static final int timeInMillis = 1000 * 60 * 26;
    private static final int testTime = 1000 * 5; //TODO: Replace it later with timeInMillis.

    private static AlarmManager alarmManager;
    private static PendingIntent pendingIntent;
    private static Context context;

    public static void set(Context context) {
        prepare(context);
        setAlarmReceiver();
        setAlarm();
    }

    private static void prepare(Context _context) {
        context = _context;
    }

    private static void setAlarmReceiver() {
        Intent intent = new Intent(context, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(context, 1, intent, 0);
    }

    private static void setAlarm() {
        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + testTime, pendingIntent);
    }

    public static void cancelAlarm() {
        if (alarmManager != null)
            alarmManager.cancel(pendingIntent);
    }
}
