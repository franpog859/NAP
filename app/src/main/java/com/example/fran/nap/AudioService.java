package com.example.fran.nap;

import android.content.Context;
import android.media.MediaPlayer;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Fran on 21.06.2018.
 */

public class AudioService {

    private final static int INTRO_VOLUME = 50;
    private final static int START_ALARM_VOLUME = 75;
    private final static int FINISH_ALARM_VOLUME = 100;

    private final static int START_ALARM_MILLIS = 10 * 1000;

    public static MediaPlayer mediaPlayer;

    public static void playIntro(Context context) {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.intro);
        VolumeService.setMediaPlayerPercentVolume(mediaPlayer, INTRO_VOLUME);
        mediaPlayer.start();
    }

    public static void startAlarmSounds(final Context context) {
        setAlarmVolume();
        playNextSound(context);
    }

    private static void setAlarmVolume() {
        VolumeService.setMediaPlayerPercentVolume(mediaPlayer, START_ALARM_VOLUME);
        Timer timer = new Timer();
        TimerTask setFinishVolume = new TimerTask() {
            @Override
            public void run() {
                VolumeService.setMediaPlayerPercentVolume(mediaPlayer, FINISH_ALARM_VOLUME);
            }
        };
        timer.schedule(setFinishVolume, START_ALARM_MILLIS);
    }

    private static void playNextSound(final Context context) {
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
                AudioService.playNextSound(context);
            }
        };
        timer.schedule(playNextSound, soundDuration + 100);
    }
}
