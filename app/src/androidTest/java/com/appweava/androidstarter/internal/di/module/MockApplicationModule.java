package com.appweava.androidstarter.internal.di.module;

import android.content.Context;

import com.appweava.androidstarter.AppInitializer;
import com.appweava.androidstarter.StarterApp;
import com.appweava.androidstarter.UiThread;
import com.appweava.androidstarterdata.executor.RxExecutor;
import com.appweava.androidstarterdomain.executor.ExecutionThread;
import com.appweava.androidstarterdomain.executor.PostExecutionThread;

import org.mockito.Mockito;

/**
 * MockApplicationModule
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/23/16
 */
public class MockApplicationModule extends ApplicationModule {

    public MockApplicationModule() {
        super(Mockito.mock(StarterApp.class));
    }

    @Override
    Context provideApplicationContext() {
        return Mockito.mock(Context.class);
    }

    @Override
    ExecutionThread provideThreadExecutor(RxExecutor rxExecutor) {
        return rxExecutor;
    }

    @Override
    PostExecutionThread providePostExecutionThread(UiThread uiThread) {
        return uiThread;
    }

    @Override
    AppInitializer provideAppInitializer() {
        return Mockito.mock(AppInitializer.class);
    }
}
