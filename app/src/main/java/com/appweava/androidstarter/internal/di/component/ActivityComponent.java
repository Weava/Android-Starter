package com.appweava.androidstarter.internal.di.component;

import android.app.Activity;

import com.appweava.androidstarter.internal.di.PerActivity;
import com.appweava.androidstarter.internal.di.module.ActivityModule;
import com.appweava.androidstarter.internal.di.module.AppModule;

import dagger.Component;

/**
 * ActivityComponent
 * <p>
 * Component containing DI graph setup for basic activity dependencies.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/29/16
 */
@PerActivity
@Component(dependencies = AppModule.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity activity();
}
