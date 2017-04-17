package com.appweava.androidstarter.ui;

import android.app.Activity;
import android.os.Bundle;

import com.appweava.androidstarter.MainActivity;
import com.appweava.androidstarter.R;

public class DebugActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debug_activity);
        startActivity(MainActivity.getCallingIntent(this));
    }
}
