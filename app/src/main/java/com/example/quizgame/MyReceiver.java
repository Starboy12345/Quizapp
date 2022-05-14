package com.example.quizgame;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "Receiver";

    @Override
    public void onReceive(Context context, Intent intent) {
       String broadcastreciveraction = intent.getAction();
        Toast.makeText(context, broadcastreciveraction, Toast.LENGTH_LONG).show();


        // receiver for airplane mode status display
        boolean isOn= intent.getBooleanExtra("state",false);
        if (isOn){
            Log.d(TAG, "Airplane mode is On");
        }else
        {
            Log.d(TAG, "Airplane mode is Off");
        }

    }
}