package com.appweava.androidstarter;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

/**
 * StarterAppTestRunner
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/22/16
 */
public class StarterAppTestRunner extends AndroidJUnitRunner {

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, StarterTestApp.class.getName(), context);
    }
}
