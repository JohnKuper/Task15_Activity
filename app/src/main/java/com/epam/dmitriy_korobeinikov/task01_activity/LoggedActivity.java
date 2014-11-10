package com.epam.dmitriy_korobeinikov.task01_activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

/**
 * Created by Dmitriy_Korobeinikov on 11/10/2014.
 */
public class LoggedActivity extends Activity {

    protected final String TAG = "Task01";
    protected String className = "LoggedActivity";

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, className + " : onCreate()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, className + " : onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, className + " : onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, className + " : onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, className + " : onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, className + " : onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, className + " : onDestroy()");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            Log.d(TAG, className + " back button was clicked");
            finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
