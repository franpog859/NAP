package com.example.fran.nap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlarmService.prepare(getApplicationContext());
        AlarmService.setAlarmReceiver();
        AlarmService.setAlarm();

        SoundsRepository.createPlaylist(getApplicationContext());

        VolumeService.prepare(getApplicationContext());
        AudioService.playIntro(getApplicationContext());
        //AirplaneService.turnAirplaneModeOn();
        //NotificationService.startCountingDown();
        //DisplayService.turnOffWithDelay(getApplicationContext());
        displayIntroToast();
    }

    private void displayIntroToast() {
        String message = "Everything is set. It's time for a nap!";
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void cancelAlarmAndClose(View view) {
        AlarmService.cancelAlarm();
        closeApp();
    }

    private void closeApp() {
        finish();
        System.exit(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //TODO: Take care of all things here.
    }
}
