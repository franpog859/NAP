package com.example.fran.nap;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Fran on 21.06.2018.
 */

public class AudioService {

    private final static int INTRO_VOLUME = 50;

    static public void playIntro(Context context) {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.intro);
        VolumeService.setMediaPlayerPercentVolume(mediaPlayer, INTRO_VOLUME);
        mediaPlayer.start();
    }

    static public void startAlarmSounds(Context context) { //TODO
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.a1);
        VolumeService.setMediaPlayerPercentVolume(mediaPlayer, INTRO_VOLUME);
        mediaPlayer.start();
    }
}
