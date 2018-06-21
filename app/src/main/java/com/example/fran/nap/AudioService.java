package com.example.fran.nap;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Fran on 21.06.2018.
 */

public class AudioService {

    private final static int INTRO_VOLUME = 50;

    public static void playIntro(Context context) {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.intro);
        VolumeService.setMediaPlayerPercentVolume(mediaPlayer, INTRO_VOLUME);
        mediaPlayer.start();
    }

    public static void startAlarmSounds(Context context) { //TODO
        int soundId = SoundsRepository.getRandomSoundId();
        MediaPlayer mediaPlayer = MediaPlayer.create(context, soundId);
        VolumeService.setMediaPlayerPercentVolume(mediaPlayer, INTRO_VOLUME);
        mediaPlayer.start();
    }
}
