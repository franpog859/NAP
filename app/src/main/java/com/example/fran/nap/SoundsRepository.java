package com.example.fran.nap;

import android.content.Context;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Fran on 21.06.2018.
 */

public class SoundsRepository {

    static public final int NUMBER_OF_SOUNDS = 39;

    static public ArrayList<Integer> playlist;
    static private Context context;

    static public void createPlaylist(Context _context) {
        context = _context;
        playlist = new ArrayList<>();
        for (int i = 1; i <= NUMBER_OF_SOUNDS; i++) {
            String stringId = 'a' + Integer.toString(i);
            int resourceId = context.getResources().getIdentifier(stringId, "raw", "com.example.fran.nap");
            playlist.add(resourceId);
        }
    }

    static public int getRandomSoundId() {
        Random randomGenerator = new Random();
        int randomSoundNumber = randomGenerator.nextInt(NUMBER_OF_SOUNDS) + 1;
        return playlist.get(randomSoundNumber);
    }
}
