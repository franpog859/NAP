package com.example.fran.nap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class LockActivity extends AppCompatActivity {

    private Window wind;
    private boolean isSoundStarted = false;

    @Override
    protected void onResume() {
        super.onResume();
        wind = this.getWindow();
        wind.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        wind.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        wind.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        wind.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        if (!isSoundStarted) {
            SoundService.startAlarmSounds(getApplicationContext());
            isSoundStarted = true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_screen);
    }
}
