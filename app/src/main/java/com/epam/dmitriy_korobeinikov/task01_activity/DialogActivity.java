package com.epam.dmitriy_korobeinikov.task01_activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Dmitriy_Korobeinikov on 11/7/2014.
 */
public class DialogActivity extends LoggedActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setClassName("DialogActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

    }
}
