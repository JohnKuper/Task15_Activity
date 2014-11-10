package com.epam.dmitriy_korobeinikov.task01_activity;

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
public class NameChangerActivity extends LoggedActivity implements OnClickListener {


    EditText editText;
    Button acceptBtn;
    Button backToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setClassName("NameChangerActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_changer);


        findViews();
        setListenersToBtns();

        parseIntent();

    }

    private void findViews() {
        editText = (EditText) findViewById(R.id.editText);
        acceptBtn = (Button) findViewById(R.id.acceptBtn);
        backToMain = (Button) findViewById(R.id.backToMain);
    }

    private void setListenersToBtns() {
        acceptBtn.setOnClickListener(this);
        backToMain.setOnClickListener(this);
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
                Log.d(TAG, "Back to main activity from name changer activity with clear top flag");
                Intent backToMainIntent = new Intent(this, MainActivity.class);
                backToMainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(backToMainIntent);
            default:
                break;
        }
    }

}
