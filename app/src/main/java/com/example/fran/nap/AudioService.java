package com.example.fran.nap;

import android.content.Context;
import android.media.MediaPlayer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Fran on 21.06.2018.
 */

public class AudioService {

    private final static int INTRO_VOLUME = 50;

    public static MediaPlayer mediaPlayer;

    public static void playIntro(Context context) {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.intro);
        VolumeService.setMediaPlayerPercentVolume(mediaPlayer, INTRO_VOLUME);
        mediaPlayer.start(); //TODO: Trigger the DisplayService to turn display off after the intro.
    }

    public static void startAlarmSounds(final Context context) { //TODO: Take care about the volume.
        setUpMediaPlayer(context);
        setUpNextSound(context);
    }

    private static void setUpMediaPlayer(Context context) {
        int soundId = SoundsRepository.getRandomSoundId();
        mediaPlayer = MediaPlayer.create(context, soundId);
        VolumeService.setMediaPlayerPercentVolume(mediaPlayer, 100);
        mediaPlayer.start();
    }

    private static void setUpNextSound(final Context context) {
        Timer timer = new Timer();
        int soundDuration = mediaPlayer.getDuration();
        TimerTask playNextSound = new TimerTask() {
            @Override
            public void run() {
                mediaPlayer.reset();
                AudioService.startAlarmSounds(context);
            }
        };
        timer.schedule(playNextSound, soundDuration + 100);
    }
}
