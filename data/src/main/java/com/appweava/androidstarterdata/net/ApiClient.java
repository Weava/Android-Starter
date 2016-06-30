package com.appweava.androidstarterdata.net;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ApiClient
 * <p>
 * Simple client for instantiating {@link Retrofit} instances. Should only call initApi().
 *
 * @see Retrofit
 * @see OkHttpClient
 * @see Cache
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/29/16
 */
public final class ApiClient {

    private static final int CACHE_SIZE = 1024 * 1024 * 10;
    private static final String CACHE_FILE_PATH = "cache";

    /**
     * Initialize a {@link Retrofit} instance from baseUrl.
     * Must be created by calling class.
     *
     * @param baseUrl
     *      The base url for the API
     * @return
     *      The retrofit instance to be created
     */
    public static Retrofit initApi(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(getClient())
                .build();
    }

    /**
     * Create an {@link OkHttpClient} for a {@link Retrofit} instance.
     *
     * @return
     *      {@link OkHttpClient} for retrofit instance
     */
    private static OkHttpClient getClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(getCache())
                .build();

        client.networkInterceptors().add(REWRITE_CACHE_CONTROL_INTERCEPTOR);
        client.networkInterceptors().add(new StethoInterceptor());

        return client;
    }

    /**
     * Return a cache implementation for a networking client.
     *
     * @return
     *      {@link Cache} mechanism for a netowrk client
     */
    private static Cache getCache() {
        File file = new File(CACHE_FILE_PATH);
        Cache cache = new Cache(file, CACHE_SIZE);
        return cache;
    }

    /**
     * Network interceptor for adding a cache control header. Allows for caching to occur
     * upon making a network request, even if response did not have Cache-Control.
     *
     * <p>Type: {@link Interceptor}</p>
     */
    private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response originalResponse = chain.proceed(chain.request());
            return originalResponse.newBuilder()
                    .header("Cache-Control", String.format(Locale.US,
                            "max-age=%d, only-if-cached, max-stale=%d", 120, 0))
                    .build();
        }
    };
}
