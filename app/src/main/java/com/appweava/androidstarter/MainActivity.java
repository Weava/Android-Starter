package com.appweava.androidstarter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.appweava.androidstarter.base.drawer.BaseDrawerActivity;
import com.appweava.androidstarter.feature.MvpActivity;

/**
 * MainActivity
 * <p>
 * Can be whatever you want it to be. #Imagination
 */
public class MainActivity extends BaseDrawerActivity {

    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getInjector().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startActivity(MvpActivity.getCallingIntent(this));
    }
}
