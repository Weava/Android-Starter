package com.appweava.androidstarter.internal.di.module;

import android.content.Context;

import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.facebook.stetho.okhttp3.StethoInterceptor;
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
 * DebugApiModule
 * <p>
 * {@link Module} for API and networking related dependencies.
 */
@Module
public class DebugApiModule {

    private static final TimeUnit TIMEOUT_TIME_UNIT = TimeUnit.MINUTES;
    private static final int TIMEOUT_TIME = 1;
    private static final String CACHE_DIR = "app/cache";
    private static final long CACHE_SIZE = 5 * 1024 * 1024;

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
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
    Cache provideCache() {
        return new Cache(new File(CACHE_DIR), CACHE_SIZE);
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
