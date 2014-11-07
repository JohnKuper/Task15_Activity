package com.epam.dmitriy_korobeinikov.task01_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Dmitriy_Korobeinikov on 11/7/2014.
 */
public class NameChangerActivity extends Activity implements OnClickListener {

    private final static String TAG = "Task01";

    EditText editText;
    Button acceptBtn;
    Button backToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "NameChanger Activity: onCreate()");
        setContentView(R.layout.activity_name_changer);

        editText = (EditText) findViewById(R.id.editText);
        acceptBtn = (Button) findViewById(R.id.acceptBtn);
        backToMain = (Button) findViewById(R.id.backToMain);

        acceptBtn.setOnClickListener(this);
        backToMain.setOnClickListener(this);

        parseIntent();

    }

    private void parseIntent() {
        Intent intent = getIntent();
        String btnName = intent.getStringExtra("btnName");
        editText.setText(btnName);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.acceptBtn:
                Log.d(TAG, "Click accept button");
                Intent intent = new Intent();
                String newName = editText.getText().toString();
                intent.putExtra("newBtnName", newName);
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.backToMain:
                Log.d(TAG, "Back to main activity from name changer activity");
                Intent backToMainIntent = new Intent(this, MainActivity.class);
                backToMainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(backToMainIntent);
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
        Log.d(TAG, "NameChanger Activity: onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "NameChanger Activity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "NameChanger Activity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "NameChanger Activity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "NameChanger Activity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "NameChanger Activity: onDestroy()");
    }
}
