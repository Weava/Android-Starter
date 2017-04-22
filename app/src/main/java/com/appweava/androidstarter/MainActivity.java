package com.appweava.androidstarter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.appweava.androidstarter.feature.MvpActivity;
import com.appweava.androidstarter.dependencyinjection.Injector;

/**
 * MainActivity
 * <p>
 * Can be whatever you want it to be. #Imagination
 */
public class MainActivity extends Activity {

    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvp_activity);

        Injector.getInstance().getAppGraph().inject(this);

        startActivity(MvpActivity.getCallingIntent(this));
        finish();
    }
}
