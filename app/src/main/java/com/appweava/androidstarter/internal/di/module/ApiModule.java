package com.appweava.androidstarter.internal.di.module;

import android.content.Context;

import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    private static final long CACHE_SIZE = 5 * 1024 * 1024;

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    File provideFile(Context context) {
        return context.getFilesDir();
    }

    @Provides
    @Singleton
    Cache provideCache(File file) {
        return new Cache(file, CACHE_SIZE);
    }

    @Provides
    @Singleton
    Retrofit.Builder provideRetrofitBuilder(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder();
    }

    @Provides
    @Singleton
    MvpApi provideMvpApi(Retrofit.Builder retrofit) {
        return retrofit.baseUrl("http://reddit.com/r/")
                .build()
                .create(MvpApi.class);
    }
}
