package com.example.fran.nap;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

/**
 * Created by Fran on 17.06.2018.
 */

public class VolumeService {

    private final static int MAX_VOLUME = 100;
    private static float defaultAudioManagerVolume;

    private static AudioManager audioManager;
    private static Context context;

    static public void prepare(Context _context) {
        audioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
        context = _context;
        saveDefaultUsersVolume();
        int maxAudioManagerVolume = getMaxAudioManagerVolume();
        setAudioManagerVolume(maxAudioManagerVolume);
    }

    static private void saveDefaultUsersVolume() {
        defaultAudioManagerVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
    }

    static private int getMaxAudioManagerVolume() {
        return audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
    }

    static public void setAudioManagerVolume(int volume) {
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
    }

    static public void setMediaPlayerPercentVolume(MediaPlayer mediaPlayer, int percentVolume) {
        final float volume = (float) (1.0 - (Math.log(1 + MAX_VOLUME - percentVolume) / Math.log(MAX_VOLUME)));
        mediaPlayer.setVolume(volume, volume);
    }
}
