package com.appweava.androidstarter.internal.di.module;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * DebugApiModule
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/20/16
 */
public class DebugApiModule extends ApiModule {

    private static final TimeUnit TIMEOUT_TIME_UNIT = TimeUnit.MINUTES;
    private static final int TIMEOUT_TIME = 1;

    @Override
    OkHttpClient provideOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .connectTimeout(TIMEOUT_TIME, TIMEOUT_TIME_UNIT)
                .cache(cache)
                .build();
    }
}
