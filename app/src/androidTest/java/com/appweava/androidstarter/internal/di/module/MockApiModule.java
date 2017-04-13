package com.appweava.androidstarter.internal.di.module;

import android.content.Context;

import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.appweava.androidstarterdata.feature.net.MvpApiImpl;
import com.google.gson.Gson;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * MockApiModule
 * <p>
 * Mock Api dependencies provider.
 * TODO: Properly decide what to do with dependencies
 */
public class MockApiModule extends ApiModule {

    @Override
    Gson provideGson() {
        return new Gson();
    }

    @Override
    File provideFile(Context context) {
        return context.getFilesDir();
    }

    @Override
    Cache provideCache(File file) {
        return new Cache(file, 1);
    }

    @Override
    Retrofit.Builder provideRetrofitBuilder(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder();
    }

    @Override
    MvpApi provideMvpApi(Retrofit.Builder retrofit) {
        return new MvpApiImpl();
    }

    @Override
    OkHttpClient provideOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder().build();
    }
}
