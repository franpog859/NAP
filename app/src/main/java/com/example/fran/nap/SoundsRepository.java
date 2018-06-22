package com.example.fran.nap;

import android.content.Context;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Fran on 21.06.2018.
 */

public class SoundsRepository {

    private static final int NUMBER_OF_SOUNDS = 39;

    private static ArrayList<Integer> playlist;
    private static Context context;

    public static void createPlaylist(Context _context) {
        context = _context;
        playlist = new ArrayList<>();
        for (int i = 1; i <= NUMBER_OF_SOUNDS; i++) {
            String fileName = 'a' + Integer.toString(i);
            int resourceId = context.getResources().getIdentifier(fileName, "raw", "com.example.fran.nap");
            playlist.add(resourceId);
        }
    }

    public static int getRandomSoundId() {
        Random randomGenerator = new Random();
        int randomSoundNumber = randomGenerator.nextInt(NUMBER_OF_SOUNDS);
        return playlist.get(randomSoundNumber);
    }
}
