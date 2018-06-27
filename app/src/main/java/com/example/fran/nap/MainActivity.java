package com.example.fran.nap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppService.setApp(getApplicationContext());
    }

    public void cancelAlarmAndClose(View view) {
        AlarmService.cancelAlarm();
        finish();
        AppService.shutDownApp();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
