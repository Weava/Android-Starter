package com.appweava.androidstarter.internal.di.module;

import android.content.Context;

import com.appweava.androidstarter.internal.di.qualifier.ApiEndpoint;
import com.appweava.androidstarter.internal.di.qualifier.MockMode;
import com.appweava.androidstarter.internal.di.qualifier.NetworkDelay;
import com.appweava.androidstarter.internal.di.qualifier.NetworkFailurePercent;
import com.appweava.androidstarter.internal.di.qualifier.NetworkVariancePercent;
import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.appweava.androidstarterdata.feature.net.MvpApiImpl;
import com.f2prateek.rx.preferences2.Preference;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.squareup.moshi.Moshi;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;
import timber.log.Timber;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * DebugApiModule
 * <p>
 * {@link Module} for API and networking related dependencies.
 */
@Module
public class DebugApiModule {

    private static final TimeUnit TIMEOUT_TIME_UNIT = TimeUnit.MINUTES;
    private static final int TIMEOUT_TIME = 1;
    private static final long CACHE_SIZE = 5 * 1024 * 1024;

    @Provides
    @Singleton
    HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> Timber.tag("OkHttp").v(message));
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        return loggingInterceptor;
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(Cache cache, HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .addInterceptor(loggingInterceptor)
                .connectTimeout(TIMEOUT_TIME, TIMEOUT_TIME_UNIT)
                .cache(cache)
                .build();
    }

    @Singleton
    @Provides
    Moshi provideMoshi() {
        return new Moshi.Builder()
                .build();
    }

    @Singleton
    @Provides
    File provideFile(Context context) {
        return context.getFilesDir();
    }

    @Singleton
    @Provides
    Cache provideCache(File file) {
        return new Cache(file, CACHE_SIZE);
    }

    @Provides
    @Singleton
    NetworkBehavior provideBehavior(@NetworkDelay Preference<Long> networkDelay,
                                    @NetworkFailurePercent Preference<Integer> networkFailurePercent,
                                    @NetworkVariancePercent Preference<Integer> networkVariancePercent) {
        NetworkBehavior behavior = NetworkBehavior.create();
        behavior.setDelay(networkDelay.get(), MILLISECONDS);
        behavior.setFailurePercent(networkFailurePercent.get());
        behavior.setVariancePercent(networkVariancePercent.get());
        return behavior;
    }

    @Provides
    @Singleton
    MockRetrofit provideMockRetrofit(Retrofit retrofit,
                                     NetworkBehavior behavior) {
        return new MockRetrofit.Builder(retrofit)
                .networkBehavior(behavior)
                .build();
    }

    @Provides
    @Singleton
    MockWebServer provideMockWebServer() {
        return new MockWebServer();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Moshi moshi,
                                    @ApiEndpoint Preference<String> endpointUrl) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(okHttpClient)
                .baseUrl(endpointUrl.get())
                .build();
    }

    @Singleton
    @Provides
    MvpApi provideMvpApi(@MockMode boolean isMockMode, Retrofit retrofit) {
        if (isMockMode) {
            return new MvpApiImpl();
        } else {
            return retrofit.create(MvpApi.class);
        }
    }
}
