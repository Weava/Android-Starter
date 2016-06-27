package com.appweava.androidstarter.internal.di.component;

import android.content.Context;

import com.appweava.androidstarter.base.BaseActivity;
import com.appweava.androidstarter.internal.di.module.AppModule;
import com.appweava.androidstarterdomain.executor.PostExecutionThread;
import com.appweava.androidstarterdomain.executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * AppComponent
 * <p>
 * Top level component for DI graph containing all application dependencies. Lifetime lasts for
 * all of application lifetime.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(BaseActivity baseActivity);

    /* Expose dependencies for down-stream components */
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
}
