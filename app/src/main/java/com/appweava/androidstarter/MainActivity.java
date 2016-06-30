package com.appweava.androidstarter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.appweava.androidstarter.base.drawer.BaseDrawerActivity;

/**
 * MainActivity
 * <p>
 * Can be whatever you want it to be. #Imagination
 *
 * @author <a href="mailto:aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public class MainActivity extends BaseDrawerActivity {

    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;    
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNavigator.navigateToMvpActivity(this);
    }
}
