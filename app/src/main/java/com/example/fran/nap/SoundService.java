package com.example.fran.nap;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

/**
 * Created by Fran on 17.06.2018.
 */

public class SoundService {

    private final static int MAX_VOLUME = 100;
    private final static int INTRO_VOLUME = 50;
    private static float defaultAudioManagerVolume;

    static public void prepare(Context context) {
        getUsersVolume(context);
        setAudioManagerPercentVolume(context, MAX_VOLUME);
    }

    static private void getUsersVolume(Context context) {
        AudioManager audioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
        defaultAudioManagerVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
    }

    static private void setAudioManagerPercentVolume(Context context, int percentVolume) {
        AudioManager audioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
        int maxAudioVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volume = (int) ((float)maxAudioVolume * ((float)percentVolume / (float)MAX_VOLUME));
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
    }

    static public void playIntro(Context context) {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.a1); //TODO: Change audio to Huston counting down.
        setMediaPlayerPercentVolume(mediaPlayer, INTRO_VOLUME);
        mediaPlayer.start();
    }

    static private void setMediaPlayerPercentVolume(MediaPlayer mediaPlayer, int percentVolume) {
        final float volume = (float) (1.0 - (Math.log(1 + MAX_VOLUME - percentVolume) / Math.log(MAX_VOLUME)));
        mediaPlayer.setVolume(volume, volume);
    }

    static public void startAlarmSounds(Context context) { //TODO
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.a1);
        setMediaPlayerPercentVolume(mediaPlayer, INTRO_VOLUME);
        mediaPlayer.start();
    }
}
