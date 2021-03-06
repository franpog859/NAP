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
        AlarmService.set(context);
        SoundsRepository.createPlaylist(context);
        VolumeService.prepare(context);
        AudioService.playIntro(context);
        displayIntroToast();
    }

    private static void displayIntroToast() {
        String message = "Everything is set. It's time for a nap!";
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void shutDownApp() {
        System.exit(0);
    }
}
