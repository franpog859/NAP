package com.example.fran.nap;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Fran on 27.06.2018.
 */

public class AppService {

    private static Context context;

    public static void setApp(Context _context) {
        context = _context;
        AlarmService.prepare(context);
        AlarmService.setAlarmReceiver();
        AlarmService.setAlarm();

        SoundsRepository.createPlaylist(context);

        VolumeService.prepare(context);
        AudioService.playIntro(context);
        //AirplaneService.turnAirplaneModeOn();
        //NotificationService.startCountingDown();
        //DisplayService.turnOffWithDelay(getApplicationContext());
        displayIntroToast();
    }

    private static void displayIntroToast() {
        String message = "Everything is set. It's time for a nap!";
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void shutDownApp() {
        //TODO: Take care of all things here.
        //AirplaneService.turnAirplaneModeOff();
        //VolumeService.setUsersVolume();
        System.exit(0);
    }
}
