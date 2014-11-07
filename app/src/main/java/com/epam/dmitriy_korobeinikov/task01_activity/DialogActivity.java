package com.epam.dmitriy_korobeinikov.task01_activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Dmitriy_Korobeinikov on 11/7/2014.
 */
public class DialogActivity extends Activity {

    private final static String TAG = "Task01";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        Log.d(TAG, "Dialog Activity: onCreate()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Dialog Activity: onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Dialog Activity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Dialog Activity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Dialog Activity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Dialog Activity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Dialog Activity: onDestroy()");
    }
}
