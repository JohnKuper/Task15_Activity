package com.epam.dmitriy_korobeinikov.task01_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Dmitriy_Korobeinikov on 11/7/2014.
 */
public class ActivityTwo extends Activity implements OnClickListener {

    private final static String TAG = "Task01";
    TextView msgTextView;
    Button noFlagsBtn;
    Button singleTopBtn;
    Button noHistoryBtn;
    Button nameChangerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        msgTextView = (TextView) findViewById(R.id.msgTextView);
        noFlagsBtn = (Button) findViewById(R.id.noFlagsBtn);
        singleTopBtn = (Button) findViewById(R.id.singleTopBtn);
        noHistoryBtn = (Button) findViewById(R.id.noHistoryBtn);
        nameChangerBtn = (Button) findViewById(R.id.nameChangerBtn);

        noFlagsBtn.setOnClickListener(this);
        singleTopBtn.setOnClickListener(this);
        noHistoryBtn.setOnClickListener(this);
        nameChangerBtn.setOnClickListener(this);
        parseIntent();

        Log.d(TAG, "ActivityTwo: onCreate()");
    }

    private void parseIntent() {
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        msgTextView.setText(message);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.noFlagsBtn:
                Log.d(TAG,"Start main activity with no flags");
                Intent noFlagsIntent = new Intent(this, MainActivity.class);
                startActivity(noFlagsIntent);
                break;
            case R.id.singleTopBtn:
                Log.d(TAG,"Start main activity with reorder to front flag");
                Intent singleTopIntent = new Intent(this, MainActivity.class);
                singleTopIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(singleTopIntent);
                break;
            case R.id.noHistoryBtn:
                Log.d(TAG,"Start main activity with no history flag");
                Intent noHistoryIntent = new Intent(this, MainActivity.class);
                noHistoryIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(noHistoryIntent);
                break;
            case R.id.nameChangerBtn:
                Log.d(TAG,"Start name changer activity from activity two");
                Intent nameChangerIntent = new Intent(this, NameChangerActivity.class);
                startActivity(nameChangerIntent);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            Log.d(TAG, this.getLocalClassName() + " back button was clicked");
            finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "ActivityTwo: onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ActivityTwo: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ActivityTwo: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ActivityTwo: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ActivityTwo: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ActivityTwo: onDestroy()");
    }
}
