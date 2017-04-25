package com.appweava.androidstarter.presentation.dependencyinjection.module;

import java.io.File;

import okhttp3.Cache;

/**
 * MockApiModule
 * <p>
 * Mock Api dependencies provider.
 * TODO: Properly decide what to do with dependencies
 */
public class MockApiModule extends DebugApiModule {

    @Override
    Cache provideCache(File file) {
        return new Cache(file, 1);
    }
}
