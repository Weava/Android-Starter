package com.appweava.androidstarter.internal.di.module;

import android.content.Context;

import com.appweava.androidstarter.internal.di.qualifier.NetworkDelay;
import com.appweava.androidstarter.internal.di.qualifier.NetworkFailurePercent;
import com.appweava.androidstarter.internal.di.qualifier.NetworkVariancePercent;
import com.f2prateek.rx.preferences2.Preference;
import com.squareup.moshi.Moshi;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

/**
 * MockApiModule
 * <p>
 * Mock Api dependencies provider.
 * TODO: Properly decide what to do with dependencies
 */
public class MockApiModule extends DebugApiModule {

    @Override
    File provideFile(Context context) {
        return context.getFilesDir();
    }

    @Override
    Cache provideCache(File file) {
        return new Cache(file, 1);
    }

    @Override
    HttpLoggingInterceptor provideLoggingInterceptor() {
        return super.provideLoggingInterceptor();
    }

    @Override
    OkHttpClient provideOkHttpClient(Cache cache, HttpLoggingInterceptor loggingInterceptor) {
        return super.provideOkHttpClient(cache, loggingInterceptor);
    }

    @Override
    Moshi provideMoshi() {
        return super.provideMoshi();
    }

    @Override
    NetworkBehavior provideBehavior(@NetworkDelay Preference<Long> networkDelay, @NetworkFailurePercent Preference<Integer> networkFailurePercent, @NetworkVariancePercent Preference<Integer> networkVariancePercent) {
        return super.provideBehavior(networkDelay, networkFailurePercent, networkVariancePercent);
    }

    @Override
    MockRetrofit provideMockRetrofit(Retrofit retrofit, NetworkBehavior behavior) {
        return super.provideMockRetrofit(retrofit, behavior);
    }

    @Override
    MockWebServer provideMockWebServer() {
        return super.provideMockWebServer();
    }


}
