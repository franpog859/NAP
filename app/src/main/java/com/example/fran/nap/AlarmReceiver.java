package com.example.fran.nap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Fran on 17.04.2018.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        turnLockScreenActivityOn(context);
    }

    private void turnLockScreenActivityOn(Context context) {
        Intent lockScreen = new Intent(context, LockActivity.class);
        lockScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(lockScreen);
    }
}
