package com.epam.dmitriy_korobeinikov.task01_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;


public class MainActivity extends LoggedActivity implements OnClickListener {

    Button explicitIntentBtn;
    Button impliciIntentBtn;
    Button dialogActivityBtn;
    Button forRenameBtn;



    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setClassName("MainActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setListenersForBtns();
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
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("renameBtnText",forRenameBtn.getText());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        forRenameBtn.setText(savedInstanceState.getCharSequence("renameBtnText"));
    }
}
