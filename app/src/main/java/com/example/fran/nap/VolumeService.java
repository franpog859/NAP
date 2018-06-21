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

    public static void prepare(Context _context) {
        setInternalVariables(_context);
        saveDefaultUsersVolume();
        int maxAudioManagerVolume = getMaxAudioManagerVolume();
        setAudioManagerVolume(maxAudioManagerVolume);
    }

    private static void setInternalVariables(Context _context) {
        context = _context;
        audioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
    }

    private static void saveDefaultUsersVolume() {
        defaultAudioManagerVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
    }

    private static int getMaxAudioManagerVolume() {
        return audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
    }

    private static void setAudioManagerVolume(int volume) {
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
    }

    public static void setMediaPlayerPercentVolume(MediaPlayer mediaPlayer, int percentVolume) {
        final float volume = (float) (1.0 - (Math.log(1 + MAX_VOLUME - percentVolume) / Math.log(MAX_VOLUME)));
        mediaPlayer.setVolume(volume, volume);
    }
}
