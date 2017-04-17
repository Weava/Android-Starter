package com.appweava.androidstarter.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.appweava.androidstarter.R;
import com.appweava.androidstarter.base.ui.ViewContainer;
import com.appweava.androidstarter.debug.ContextualDebugActions;
import com.appweava.androidstarter.debug.LumberYard;
import com.appweava.androidstarter.debug.bugreport.BugReportLens;
import com.appweava.androidstarter.internal.di.qualifier.PixelGridEnabled;
import com.appweava.androidstarter.internal.di.qualifier.PixelRatioEnabled;
import com.appweava.androidstarter.internal.di.qualifier.ScalpelEnabled;
import com.appweava.androidstarter.internal.di.qualifier.ScalpelWireframeEnabled;
import com.appweava.androidstarter.internal.di.qualifier.SeenDebugDrawer;
import com.f2prateek.rx.preferences2.Preference;
import com.jakewharton.madge.MadgeFrameLayout;
import com.jakewharton.scalpel.ScalpelFrameLayout;
import com.mattprecious.telescope.TelescopeLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;

import static android.os.PowerManager.ACQUIRE_CAUSES_WAKEUP;
import static android.os.PowerManager.ON_AFTER_RELEASE;
import static android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
import static android.view.WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;

public class DebugViewContainer implements ViewContainer {

    private final LumberYard lumberYard;
    private final Preference<Boolean> seenDebugDrawer;
    private final Preference<Boolean> pixelGridEnabled;
    private final Preference<Boolean> pixelRatioEnabled;
    private final Preference<Boolean> scalpelEnabled;
    private final Preference<Boolean> scalpelWireframeEnabled;

    static class ViewHolder {
        @BindView(R.id.debug_drawer_layout) DrawerLayout drawerLayout;
        @BindView(R.id.debug_drawer) ViewGroup debugDrawer;
        @BindView(R.id.telescope_container) TelescopeLayout telescopeLayout;
        @BindView(R.id.madge_container) MadgeFrameLayout madgeFrameLayout;
        @BindView(R.id.debug_content) ScalpelFrameLayout content;
    }

    @Inject
    public DebugViewContainer(LumberYard lumberYard,
                              @SeenDebugDrawer Preference<Boolean> seenDebugDrawer,
                              @PixelGridEnabled Preference<Boolean> pixelGridEnabled,
                              @PixelRatioEnabled Preference<Boolean> pixelRatioEnabled,
                              @ScalpelEnabled Preference<Boolean> scalpelEnabled,
                              @ScalpelWireframeEnabled Preference<Boolean> scalpelWireframeEnabled) {
        this.lumberYard = lumberYard;
        this.seenDebugDrawer = seenDebugDrawer;
        this.pixelGridEnabled = pixelGridEnabled;
        this.pixelRatioEnabled = pixelRatioEnabled;
        this.scalpelEnabled = scalpelEnabled;
        this.scalpelWireframeEnabled = scalpelWireframeEnabled;
    }

    @Override
    public ViewGroup forActivity(Activity activity) {
        activity.setContentView(R.layout.debug_activity_frame);

        final ViewHolder viewHolder = new ViewHolder();
        ButterKnife.bind(viewHolder, activity);

        final Context drawerContext = new ContextThemeWrapper(activity, R.style.Theme_StarterApp);
        final DebugView debugView = new DebugView(drawerContext);
        viewHolder.debugDrawer.addView(debugView);

        ContextualDebugActions contextualDebugActions = debugView.getContextualDebugActions();
        contextualDebugActions.setActionClickListener(v -> viewHolder.drawerLayout.closeDrawers());

        viewHolder.content.setOnHierarchyChangeListener(
                HierarchyTreeChangeListener.wrap(contextualDebugActions)
        );

        viewHolder.drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerOpened(View drawerView) {
                debugView.onDrawerOpened();
            }
        });

        TelescopeLayout.cleanUp(activity); // Clean up any old screenshots.
        viewHolder.telescopeLayout.setLens(new BugReportLens(activity, lumberYard));

        // If you have not seen the debug drawer before, show it with a message
        if (!seenDebugDrawer.get()) {
            viewHolder.drawerLayout.postDelayed(() -> {
                viewHolder.drawerLayout.openDrawer(GravityCompat.END);
                Toast.makeText(drawerContext, R.string.debug_drawer_welcome, Toast.LENGTH_LONG).show();
            }, 1000);
            seenDebugDrawer.set(true);
        }

        final CompositeDisposable subscriptions = new CompositeDisposable();
        setupMadge(viewHolder, subscriptions);
        setupScalpel(viewHolder, subscriptions);

        final Application app = activity.getApplication();
        app.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override public void onActivityDestroyed(Activity lifecycleActivity) {
                if (lifecycleActivity == activity) {
                    subscriptions.dispose();
                    app.unregisterActivityLifecycleCallbacks(this);
                }
            }

            @Override public void onActivityCreated(Activity activity, Bundle bundle) {}
            @Override public void onActivityStarted(Activity activity) {}
            @Override public void onActivityResumed(Activity activity) {}
            @Override public void onActivityPaused(Activity activity) {}
            @Override public void onActivityStopped(Activity activity) {}
            @Override public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {}
        });

        //riseAndShine(activity);
        return viewHolder.content;
    }

    private void setupMadge(final ViewHolder viewHolder, CompositeDisposable disposables) {
        disposables.add(pixelGridEnabled.asObservable().subscribe(enabled -> {
            viewHolder.madgeFrameLayout.setOverlayEnabled(enabled);
        }));
        disposables.add(pixelRatioEnabled.asObservable().subscribe(enabled -> {
            viewHolder.madgeFrameLayout.setOverlayRatioEnabled(enabled);
        }));
    }

    private void setupScalpel(final ViewHolder viewHolder, CompositeDisposable disposables) {
        disposables.add(scalpelEnabled.asObservable().subscribe(enabled -> {
            viewHolder.content.setLayerInteractionEnabled(enabled);
        }));
        disposables.add(scalpelWireframeEnabled.asObservable().subscribe(enabled -> {
            viewHolder.content.setDrawViews(!enabled);
        }));
    }

    /**
     * Show the activity over the lock-screen and wake up the device. If you launched the app manually
     * both of these conditions are already true. If you deployed from the IDE, however, this will
     * save you from hundreds of power button presses and pattern swiping per day!
     */
    public static void riseAndShine(Activity activity) {
        activity.getWindow().addFlags(FLAG_SHOW_WHEN_LOCKED);

        PowerManager power = (PowerManager) activity.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock lock =
                power.newWakeLock(FLAG_KEEP_SCREEN_ON | ACQUIRE_CAUSES_WAKEUP | ON_AFTER_RELEASE, "wakeup!");
        lock.acquire();
        lock.release();
    }
}
