package com.appweava.androidstarter.internal.di.module;

import com.appweava.androidstarter.internal.di.qualifier.InstrumentationTest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DebugTestPrepModule {

    static boolean instrumentationTest = false;

    @Provides
    @Singleton
    @InstrumentationTest
    boolean provideIsInstrumentationTest() {
        return instrumentationTest;
    }
}
