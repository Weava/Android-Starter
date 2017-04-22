package com.appweava.androidstarter.dependencyinjection.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.appweava.androidstarter.base.IntentFactory;
import com.appweava.androidstarter.debugdrawer.DebugIntentFactory;
import com.appweava.androidstarter.debugdrawer.MockPicassoRequestHandler;
import com.appweava.androidstarter.dependencyinjection.qualifier.AnimationSpeed;
import com.appweava.androidstarter.dependencyinjection.qualifier.ApiEndpoint;
import com.appweava.androidstarter.dependencyinjection.qualifier.CaptureIntents;
import com.appweava.androidstarter.dependencyinjection.qualifier.DebugPrefs;
import com.appweava.androidstarter.dependencyinjection.qualifier.InstrumentationTest;
import com.appweava.androidstarter.dependencyinjection.qualifier.MockMode;
import com.appweava.androidstarter.dependencyinjection.qualifier.NetworkDelay;
import com.appweava.androidstarter.dependencyinjection.qualifier.NetworkFailurePercent;
import com.appweava.androidstarter.dependencyinjection.qualifier.NetworkVariancePercent;
import com.appweava.androidstarter.dependencyinjection.qualifier.PicassoDebugging;
import com.appweava.androidstarter.dependencyinjection.qualifier.PixelGridEnabled;
import com.appweava.androidstarter.dependencyinjection.qualifier.PixelRatioEnabled;
import com.appweava.androidstarter.dependencyinjection.qualifier.ScalpelEnabled;
import com.appweava.androidstarter.dependencyinjection.qualifier.ScalpelWireframeEnabled;
import com.appweava.androidstarter.dependencyinjection.qualifier.SeenDebugDrawer;
import com.appweava.androidstarterdata.ApiEndpoints;
import com.f2prateek.rx.preferences2.Preference;
import com.f2prateek.rx.preferences2.RxSharedPreferences;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.mock.NetworkBehavior;
import timber.log.Timber;

@Module
public class DebugDataModule {
    private static final int DEFAULT_ANIMATION_SPEED = 1; // 1x (normal) speed.
    private static final boolean DEFAULT_PICASSO_DEBUGGING = false; // Debug indicators displayed
    private static final boolean DEFAULT_PIXEL_GRID_ENABLED = false; // No pixel grid overlay.
    private static final boolean DEFAULT_PIXEL_RATIO_ENABLED = false; // No pixel ratio overlay.
    private static final boolean DEFAULT_SCALPEL_ENABLED = false; // No crazy 3D view tree.
    private static final boolean DEFAULT_SCALPEL_WIREFRAME_ENABLED = false; // Draw views by default.
    private static final boolean DEFAULT_SEEN_DEBUG_DRAWER = false; // Show debug drawer first time.
    private static final boolean DEFAULT_CAPTURE_INTENTS = true; // Capture external intents.

    @Provides
    @Singleton
    SharedPreferences getSharedPrefs(Context context) {
        return context.getSharedPreferences("debug_prefs", 0);
    }

    @Provides
    @Singleton
    @DebugPrefs
    RxSharedPreferences provideRxSharedPreferences(SharedPreferences prefs) {
        return RxSharedPreferences.create(prefs);
    }

    @Provides
    @Singleton
    IntentFactory provideIntentFactory(@MockMode boolean isMockMode,
                                       @CaptureIntents Preference<Boolean> captureIntents) {
        return new DebugIntentFactory(IntentFactory.REAL, isMockMode, captureIntents);
    }

    @Provides
    @Singleton
    @ApiEndpoint
    Preference<String> provideEndpointPreference(@DebugPrefs RxSharedPreferences preferences) {
        return preferences.getString("debug_endpoint", ApiEndpoints.MOCK_MODE.url);
    }

    @Provides
    @Singleton
    @MockMode
    boolean provideIsMockMode(@ApiEndpoint Preference<String> endpoint,
                              @InstrumentationTest boolean isInstrumentationTest) {
        // Running in an instrumentation forces mock mode.
        return isInstrumentationTest || ApiEndpoints.isMockMode(endpoint.get());
    }

    @Provides
    @Singleton
    @NetworkDelay
    Preference<Long> provideNetworkDelay(@DebugPrefs RxSharedPreferences preferences) {
        return preferences.getLong("debug_network_delay", 2000l);
    }

    @Provides
    @Singleton
    @NetworkFailurePercent
    Preference<Integer> provideNetworkFailurePercent(@DebugPrefs RxSharedPreferences preferences) {
        return preferences.getInteger("debug_network_failure_percent", 3);
    }

    @Provides
    @Singleton
    @NetworkVariancePercent
    Preference<Integer> provideNetworkVariancePercent(@DebugPrefs RxSharedPreferences preferences) {
        return preferences.getInteger("debug_network_variance_percent", 40);
    }

    @Provides
    @Singleton
    @CaptureIntents
    Preference<Boolean> provideCaptureIntentsPreference(@DebugPrefs RxSharedPreferences preferences) {
        return preferences.getBoolean("debug_capture_intents", DEFAULT_CAPTURE_INTENTS);
    }

    @Provides
    @Singleton
    @AnimationSpeed
    Preference<Integer> provideAnimationSpeed(@DebugPrefs RxSharedPreferences preferences) {
        return preferences.getInteger("debug_animation_speed", DEFAULT_ANIMATION_SPEED);
    }

    @Provides
    @Singleton
    @PicassoDebugging
    Preference<Boolean> providePicassoDebugging(@DebugPrefs RxSharedPreferences preferences) {
        return preferences.getBoolean("debug_picasso_debugging", DEFAULT_PICASSO_DEBUGGING);
    }

    @Provides
    @Singleton
    @PixelGridEnabled
    Preference<Boolean> providePixelGridEnabled(@DebugPrefs RxSharedPreferences preferences) {
        return preferences.getBoolean("debug_pixel_grid_enabled", DEFAULT_PIXEL_GRID_ENABLED);
    }

    @Provides
    @Singleton
    @PixelRatioEnabled
    Preference<Boolean> providePixelRatioEnabled(@DebugPrefs RxSharedPreferences preferences) {
        return preferences.getBoolean("debug_pixel_ratio_enabled", DEFAULT_PIXEL_RATIO_ENABLED);
    }

    @Provides
    @Singleton
    @SeenDebugDrawer
    Preference<Boolean> provideSeenDebugDrawer(@DebugPrefs RxSharedPreferences preferences) {
        return preferences.getBoolean("debug_seen_debug_drawer", DEFAULT_SEEN_DEBUG_DRAWER);
    }

    @Provides
    @Singleton
    @ScalpelEnabled
    Preference<Boolean> provideScalpelEnabled(@DebugPrefs RxSharedPreferences preferences) {
        return preferences.getBoolean("debug_scalpel_enabled", DEFAULT_SCALPEL_ENABLED);
    }

    @Provides
    @Singleton
    @ScalpelWireframeEnabled
    Preference<Boolean> provideScalpelWireframeEnabled(@DebugPrefs RxSharedPreferences preferences) {
        return preferences.getBoolean("debug_scalpel_wireframe_drawer",
                DEFAULT_SCALPEL_WIREFRAME_ENABLED);
    }

    @Provides
    @Singleton
    Picasso providePicasso(OkHttpClient client, NetworkBehavior behavior,
                           @MockMode boolean isMockMode, Application app) {
        Picasso.Builder builder = new Picasso.Builder(app).downloader(new OkHttp3Downloader(client));
        if (isMockMode) {
            builder.addRequestHandler(new MockPicassoRequestHandler(behavior, app.getAssets()));
        }
        builder.listener((picasso, uri, exception) -> {
            Timber.e(exception, "Error while loading image %s", uri);
        });
        return builder.build();
    }
}
