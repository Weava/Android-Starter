package com.appweava.androidstarter.internal.di.module;

import android.content.Context;

import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.appweava.androidstarterdata.feature.net.MvpApiImpl;
import com.google.gson.Gson;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * MockApiModule
 * <p>
 * Mock Api dependencies provider.
 * TODO: Properly decide what to do with dependencies
 */
@Module
public class MockApiModule {

    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    File provideFile(Context context) {
        return context.getFilesDir();
    }

    @Provides
    @Singleton
    Cache provideCache(File file) {
        return new Cache(file, 1);
    }

    @Provides
    @Singleton
    Retrofit.Builder provideRetrofitBuilder(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder();
    }

    @Provides
    @Singleton
    MvpApi provideMvpApi(Retrofit.Builder retrofit) {
        return new MvpApiImpl();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder().build();
    }
}
