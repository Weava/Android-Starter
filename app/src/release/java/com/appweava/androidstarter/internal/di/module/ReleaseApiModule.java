package com.appweava.androidstarter.internal.di.module;

import android.content.Context;

import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ReleaseApiModule
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/24/16
 */
@Module
public class ReleaseApiModule {

    private static final TimeUnit TIMEOUT_TIME_UNIT = TimeUnit.MINUTES;
    private static final int TIMEOUT_TIME = 1;
    private static final long CACHE_SIZE = 5 * 1024 * 1024;

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_TIME, TIMEOUT_TIME_UNIT)
                .cache(cache)
                .build();
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
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient);
    }

    @Provides
    @Singleton
    MvpApi provideMvpApi(Retrofit.Builder retrofit) {
        return retrofit.baseUrl("http://reddit.com/r/")
                .build()
                .create(MvpApi.class);
    }
}
