package com.epam.dmitriy_korobeinikov.task01_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener {

    private final static String TAG = "Task01";
    Button explicitIntentBtn;
    Button impliciIntentBtn;
    Button dialogActivityBtn;
    Button forRenameBtn;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setListenersForBtns();

        Log.d(TAG, "MainActivity: onCreate()");
    }

    private void findViews() {
        explicitIntentBtn = (Button) findViewById(R.id.explicitBtn);
        impliciIntentBtn = (Button) findViewById(R.id.implicitBtn);
        dialogActivityBtn = (Button) findViewById(R.id.dialogBtn);
        forRenameBtn = (Button) findViewById(R.id.nameChangerBtn);

    }

    private void setListenersForBtns() {
        explicitIntentBtn.setOnClickListener(this);
        impliciIntentBtn.setOnClickListener(this);
        dialogActivityBtn.setOnClickListener(this);
        forRenameBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.explicitBtn:
                Log.d(TAG, "Start with explicit intent");
                Intent explicitIntent = new Intent(this, ActivityTwo.class);
                explicitIntent.putExtra("message", "The activity was launched through explicit intent");
                startActivity(explicitIntent);
                break;
            case R.id.implicitBtn:
                Log.d(TAG, "Start with implicit intent");
                Intent implicitIntent = new Intent("com.epam.korobeynikov");
                implicitIntent.putExtra("message", "The activity was launched through implicit intent");
                startActivity(implicitIntent);
                break;
            case R.id.dialogBtn:
                Log.d(TAG, "Start dialog activity");
                Intent dialogActivityIntent = new Intent(this, DialogActivity.class);
                startActivity(dialogActivityIntent);
                break;
            case R.id.nameChangerBtn:
                Log.d(TAG, "Start name changer activity from main activity");
                Intent nameChangerIntent = new Intent(this, NameChangerActivity.class);
                nameChangerIntent.putExtra("btnName", forRenameBtn.getText().toString());
                startActivityForResult(nameChangerIntent, 1);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String btnName = data.getStringExtra("newBtnName");
            forRenameBtn.setText(btnName);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity: onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy()");
    }
}
