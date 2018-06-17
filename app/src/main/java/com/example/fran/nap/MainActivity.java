package com.example.fran.nap;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int timeInMillis = 1000 * 60 * 26;
    private final int testTime = 1000 * 5; //TODO: Replace it later with timeInMillis.

    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAlarmReceiver();
        setAlarm();
        SoundService.playIntro(getApplicationContext());
        //AirplaneService.turnAirplaneModeOn();
        //NotificationService.startCountingDown();
        displayIntroToast();
        turnDisplayOffAfterIntro();
    }

    private void setAlarmReceiver() {
        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        pendingIntent = PendingIntent
                .getBroadcast(getApplicationContext(), 1, intent, 0);
    }

    private void setAlarm() {
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + testTime, pendingIntent);
    }

    private void displayIntroToast() {
        String message = "Everything is set. It's time for a nap!";
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void turnDisplayOffAfterIntro() {
        //TODO
    }

    public void cancelAlarmAndClose(View view) {
        if (alarmManager != null) {
            alarmManager.cancel(pendingIntent);
            closeApp();
        }
    }

    private void closeApp() {
        finish();
        System.exit(0);
    }
}
