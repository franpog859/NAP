package com.example.fran.nap;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Fran on 17.06.2018.
 */

public class SoundService {

    static public void playIntro(Context context) {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.a1);
        mediaPlayer.start();
    }

    static public void startAlarmSounds(Context context) {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.a1);
        mediaPlayer.start();
    }
}
