package com.appweava.androidstarter.feature;

import com.appweava.androidstarter.feature.view.MvpActivity;
import com.appweava.androidstarter.internal.di.PerActivity;
import com.appweava.androidstarter.internal.di.component.ActivityComponent;
import com.appweava.androidstarter.internal.di.component.AppComponent;
import com.appweava.androidstarter.internal.di.module.ActivityModule;

import dagger.Component;

/**
 * MvpComponent
 * <p>
 * {@link Component} containing dependency graph information for Mvp featureset.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/29/16
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = { ActivityModule.class, MvpModule.class })
public interface MvpComponent extends ActivityComponent {
    void inject(MvpActivity mvpActivity);
}
