package com.appweava.androidstarter.internal.di.component;

import android.app.Activity;

import com.appweava.androidstarter.internal.di.ActivityScope;
import com.appweava.androidstarter.internal.di.module.ActivityModule;
import com.appweava.androidstarter.internal.di.module.AppModule;

import dagger.Component;

/**
 * ActivityComponent
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/29/16
 */
@ActivityScope
@Component(dependencies = AppModule.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity activity();
}
