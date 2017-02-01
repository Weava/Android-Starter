package com.appweava.androidstarter;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

/**
 * StarterAppTestRunner
 * <p>
 * {@link AndroidJUnitRunner} extension that allows us to use our custom test {@link Application}
 * class in out instrumentation tests.
 */
public class StarterAppTestRunner extends AndroidJUnitRunner {

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, StarterTestApp.class.getName(), context);
    }
}
