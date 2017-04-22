package com.appweava.androidstarter.dependencyinjection.module;

import com.appweava.androidstarter.dependencyinjection.qualifier.InstrumentationTest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DebugTestPrepModule {

    private boolean instrumentationTest;

    public DebugTestPrepModule(boolean isInstrumentationTest) {
        this.instrumentationTest = isInstrumentationTest;
    }

    @Provides
    @Singleton
    @InstrumentationTest
    boolean provideIsInstrumentationTest() {
        return instrumentationTest;
    }
}
