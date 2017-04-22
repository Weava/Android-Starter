package com.appweava.androidstarter.debugdrawer.ui;

import android.animation.ValueAnimator;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.appweava.androidstarter.BuildConfig;
import com.appweava.androidstarter.R;
import com.appweava.androidstarter.base.adapter.EnumAdapter;
import com.appweava.androidstarter.debugdrawer.ContextualDebugActions;
import com.appweava.androidstarter.debugdrawer.LumberYard;
import com.appweava.androidstarter.debugdrawer.adapter.AnimationSpeedAdapter;
import com.appweava.androidstarter.debugdrawer.adapter.NetworkDelayAdapter;
import com.appweava.androidstarter.debugdrawer.adapter.NetworkErrorAdapter;
import com.appweava.androidstarter.debugdrawer.adapter.NetworkVarianceAdapter;
import com.appweava.androidstarter.dependencyinjection.Injector;
import com.appweava.androidstarter.dependencyinjection.qualifier.AnimationSpeed;
import com.appweava.androidstarter.dependencyinjection.qualifier.ApiEndpoint;
import com.appweava.androidstarter.dependencyinjection.qualifier.CaptureIntents;
import com.appweava.androidstarter.dependencyinjection.qualifier.MockMode;
import com.appweava.androidstarter.dependencyinjection.qualifier.NetworkDelay;
import com.appweava.androidstarter.dependencyinjection.qualifier.NetworkFailurePercent;
import com.appweava.androidstarter.dependencyinjection.qualifier.NetworkVariancePercent;
import com.appweava.androidstarter.dependencyinjection.qualifier.PicassoDebugging;
import com.appweava.androidstarter.dependencyinjection.qualifier.PixelGridEnabled;
import com.appweava.androidstarter.dependencyinjection.qualifier.PixelRatioEnabled;
import com.appweava.androidstarter.dependencyinjection.qualifier.ScalpelEnabled;
import com.appweava.androidstarter.dependencyinjection.qualifier.ScalpelWireframeEnabled;
import com.appweava.androidstarterdata.ApiEndpoints;
import com.f2prateek.rx.preferences2.Preference;
import com.fernandocejas.arrow.strings.Strings;
import com.jakewharton.processphoenix.ProcessPhoenix;
import com.jakewharton.rxbinding2.widget.RxAdapterView;
import com.squareup.leakcanary.internal.DisplayLeakActivity;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.StatsSnapshot;

import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.TemporalAccessor;

import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Set;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.mock.NetworkBehavior;
import timber.log.Timber;

import static butterknife.ButterKnife.findById;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class DebugView extends FrameLayout {
    private static final DateTimeFormatter DATE_DISPLAY_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a", Locale.US).withZone(ZoneId.systemDefault());

    @BindView(R.id.debug_contextual_title) View contextualTitleView;
    @BindView(R.id.debug_contextual_list) LinearLayout contextualListView;

    @BindView(R.id.debug_network_endpoint) Spinner endpointSpinner;
    @BindView(R.id.debug_network_endpoint_edit) ImageButton endpointEdit;
    @BindView(R.id.debug_network_delay_label) TextView networkDelayLabel;
    @BindView(R.id.debug_network_delay) Spinner networkDelaySpinner;
    @BindView(R.id.debug_network_variance_label) TextView networkVarianceLabel;
    @BindView(R.id.debug_network_variance) Spinner networkVarianceSpinner;
    @BindView(R.id.debug_network_error_label) TextView networkErrorLabel;
    @BindView(R.id.debug_network_error) Spinner networkErrorSpinner;

    @BindView(R.id.debug_capture_intents) Switch captureIntentsView;

    @BindView(R.id.debug_ui_animation_speed) Spinner uiAnimationSpeedView;
    @BindView(R.id.debug_ui_pixel_grid) Switch pixelGridView;
    @BindView(R.id.debug_ui_pixel_ratio) Switch pixelRatioView;
    @BindView(R.id.debug_ui_scalpel) Switch scalpelView;
    @BindView(R.id.debug_ui_scalpel_wireframe) Switch scalpelWireframeView;

    @BindView(R.id.debug_build_name) TextView buildNameView;
    @BindView(R.id.debug_build_code) TextView buildCodeView;
    @BindView(R.id.debug_build_sha) TextView buildShaView;
    @BindView(R.id.debug_build_date) TextView buildDateView;

    @BindView(R.id.debug_device_make) TextView deviceMakeView;
    @BindView(R.id.debug_device_model) TextView deviceModelView;
    @BindView(R.id.debug_device_resolution) TextView deviceResolutionView;
    @BindView(R.id.debug_device_density) TextView deviceDensityView;
    @BindView(R.id.debug_device_release) TextView deviceReleaseView;
    @BindView(R.id.debug_device_api) TextView deviceApiView;

    @BindView(R.id.debug_picasso_indicators) Switch picassoIndicatorsView;
    @BindView(R.id.debug_picasso_cache_size) TextView picassoCacheSizeView;
    @BindView(R.id.debug_picasso_cache_hit) TextView picassoCacheHitView;
    @BindView(R.id.debug_picasso_cache_miss) TextView picassoCacheMissView;
    @BindView(R.id.debug_picasso_decoded) TextView picassoDecodedView;
    @BindView(R.id.debug_picasso_decoded_total) TextView picassoDecodedTotalView;
    @BindView(R.id.debug_picasso_decoded_avg) TextView picassoDecodedAvgView;
    @BindView(R.id.debug_picasso_transformed) TextView picassoTransformedView;
    @BindView(R.id.debug_picasso_transformed_total) TextView picassoTransformedTotalView;
    @BindView(R.id.debug_picasso_transformed_avg) TextView picassoTransformedAvgView;

    @BindView(R.id.debug_okhttp_cache_max_size) TextView okHttpMaxCacheSizeView;
    @BindView(R.id.debug_okhttp_cache_write_error) TextView okHttpWriteErrorView;
    @BindView(R.id.debug_okhttp_cache_request_count) TextView okHttpRequestCountView;
    @BindView(R.id.debug_okhttp_cache_network_count) TextView okHttpNetworkCountView;
    @BindView(R.id.debug_okhttp_cache_hit_count) TextView okHttpCacheHitCountView;

    @Inject
    OkHttpClient client;

    @Inject
    Picasso picasso;

    @Inject
    LumberYard lumberYard;

    @Inject
    @MockMode
    boolean isMockMode;

    @Inject
    @ApiEndpoint
    Preference<String> networkEndpoint;

    @Inject
    @CaptureIntents
    Preference<Boolean> captureIntents;

    @Inject
    @AnimationSpeed
    Preference<Integer> animationSpeed;

    @Inject
    @PicassoDebugging
    Preference<Boolean> picassoDebugging;

    @Inject
    @PixelGridEnabled
    Preference<Boolean> pixelGridEnabled;

    @Inject
    @PixelRatioEnabled
    Preference<Boolean> pixelRatioEnabled;

    @Inject
    @ScalpelEnabled
    Preference<Boolean> scalpelEnabled;

    @Inject
    @ScalpelWireframeEnabled
    Preference<Boolean> scalpelWireframeEnabled;

    @Inject
    NetworkBehavior behavior;

    @Inject
    @NetworkDelay
    Preference<Long> networkDelay;

    @Inject
    @NetworkFailurePercent
    Preference<Integer> networkFailurePercent;

    @Inject
    @NetworkVariancePercent
    Preference<Integer> networkVariancePercent;

    @Inject
    Application app;

    @Inject
    Set<ContextualDebugActions.DebugAction> debugActions;

    private final ContextualDebugActions contextualDebugActions;

    public DebugView(@NonNull Context context) {
        this(context, null);
    }

    public DebugView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Injector.getInstance().getAppGraph().inject(this);

        LayoutInflater.from(context).inflate(R.layout.debug_view_content, this);
        ButterKnife.bind(this);

        this.contextualDebugActions = new ContextualDebugActions(this, debugActions);

        setupNetworkSection();
        setupMockBehaviorSection();
        setupUserInterfaceSection();
        setupBuildSection();
        setupDeviceSection();
        setupPicassoSection();
        setupOkHttpCacheSection();
    }

    public ContextualDebugActions getContextualDebugActions() {
        return contextualDebugActions;
    }

    public void onDrawerOpened() {
        refreshPicassoStats();
        refreshOkHttpCacheStats();
    }

    public View getContextualTitleView() {
        return contextualTitleView;
    }

    public LinearLayout getContextualListView() {
        return contextualListView;
    }

    private void setupNetworkSection() {
        setEndpointSection();
        setDelaySection();
        setVarianceSection();
        setErrorSection();
    }

    @OnClick(R.id.debug_network_endpoint_edit)
    void onEditEndpointClicked() {
        Timber.d("Prompting to edit custom endpoint URL.");
        // Pass in the currently selected position since we are merely editing.
        showCustomEndpointDialog(endpointSpinner.getSelectedItemPosition(), networkEndpoint.get());
    }

    private void setEndpointSection() {
        final ApiEndpoints currentEndpoint = ApiEndpoints.from(networkEndpoint.get());
        final EnumAdapter<ApiEndpoints> endpointAdapter =
                new EnumAdapter<>(getContext(), ApiEndpoints.class);
        endpointSpinner.setAdapter(endpointAdapter);
        endpointSpinner.setSelection(currentEndpoint.ordinal());

        RxAdapterView.itemSelections(endpointSpinner)
                .map(endpointAdapter::getItem)
                .filter(item -> item != currentEndpoint)
                .subscribe(selected -> {
                    if (selected == ApiEndpoints.CUSTOM) {
                        Timber.d("Custom network endpoint selected. Prompting for URL.");
                        showCustomEndpointDialog(currentEndpoint.ordinal(), "http://");
                    } else {
                        setEndpointAndRelaunch(selected.url);
                    }
                });

        // Only show the endpoint editor when a custom endpoint is in use.
        endpointEdit.setVisibility(currentEndpoint == ApiEndpoints.CUSTOM ? VISIBLE : GONE);

        if (currentEndpoint != ApiEndpoints.MOCK_MODE) {
            // Disable network controls if we are not in mock mode.
            networkDelaySpinner.setEnabled(false);
            networkVarianceSpinner.setEnabled(false);
            networkErrorSpinner.setEnabled(false);
        }
    }

    private void setDelaySection() {
        if (isMockMode) {
            final NetworkDelayAdapter delayAdapter = new NetworkDelayAdapter(getContext());
            networkDelaySpinner.setAdapter(delayAdapter);
            networkDelaySpinner.setSelection(
                    NetworkDelayAdapter.getPositionForValue(behavior.delay(MILLISECONDS)));

            RxAdapterView.itemSelections(networkDelaySpinner)
                    .map(delayAdapter::getItem)
                    .filter(item -> item != behavior.delay(MILLISECONDS))
                    .subscribe(selected -> {
                        Timber.d("Setting network delay to %sms", selected);
                        behavior.setDelay(selected, MILLISECONDS);
                        networkDelay.set(selected);
                    });
        } else {
            networkDelayLabel.setVisibility(View.GONE);
            networkDelaySpinner.setVisibility(View.GONE);
        }
    }

    private void setVarianceSection() {
        if (isMockMode) {
            final NetworkVarianceAdapter varianceAdapter = new NetworkVarianceAdapter(getContext());
            networkVarianceSpinner.setAdapter(varianceAdapter);
            networkVarianceSpinner.setSelection(
                    NetworkVarianceAdapter.getPositionForValue(behavior.variancePercent()));

            RxAdapterView.itemSelections(networkVarianceSpinner)
                    .map(varianceAdapter::getItem)
                    .filter(item -> item != behavior.variancePercent())
                    .subscribe(selected -> {
                        Timber.d("Setting network variance to %s%%", selected);
                        behavior.setVariancePercent(selected);
                        networkVariancePercent.set(selected);
                    });
        } else {
            networkVarianceLabel.setVisibility(View.GONE);
            networkVarianceSpinner.setVisibility(View.GONE);
        }
    }

    private void setErrorSection() {
        if (isMockMode) {
            final NetworkErrorAdapter errorAdapter = new NetworkErrorAdapter(getContext());
            networkErrorSpinner.setAdapter(errorAdapter);
            networkErrorSpinner.setSelection(
                    NetworkErrorAdapter.getPositionForValue(behavior.failurePercent()));

            RxAdapterView.itemSelections(networkErrorSpinner)
                    .map(errorAdapter::getItem)
                    .filter(item -> item != behavior.failurePercent())
                    .subscribe(selected -> {
                        Timber.d("Setting network error to %s%%", selected);
                        behavior.setFailurePercent(selected);
                        networkFailurePercent.set(selected);
                    });
        } else {
            networkErrorLabel.setVisibility(View.GONE);
            networkErrorSpinner.setVisibility(View.GONE);
        }
    }

    private void setupMockBehaviorSection() {
        captureIntentsView.setEnabled(isMockMode);
        captureIntentsView.setChecked(captureIntents.get());
        captureIntentsView.setOnCheckedChangeListener((compoundButton, b) -> {
            Timber.d("Capture intents set to %s", b);
            captureIntents.set(b);
        });
    }

    private void setupUserInterfaceSection() {
        setupAnimationSpeedSection();
        setupPixelGridSection();
        setupScalpelSection();
    }

    private void setupAnimationSpeedSection() {
        final AnimationSpeedAdapter speedAdapter = new AnimationSpeedAdapter(getContext());
        uiAnimationSpeedView.setAdapter(speedAdapter);
        final int animationSpeedValue = animationSpeed.get();
        uiAnimationSpeedView.setSelection(
                AnimationSpeedAdapter.getPositionForValue(animationSpeedValue));

        RxAdapterView.itemSelections(uiAnimationSpeedView)
                .map(speedAdapter::getItem)
                .filter(item -> item != animationSpeed.get())
                .subscribe(selected -> {
                    Timber.d("Setting animation speed to %sx", selected);
                    animationSpeed.set(selected);
                    applyAnimationSpeed(selected);
                });
        // Ensure the animation speed value is always applied across app restarts.
        post(() -> applyAnimationSpeed(animationSpeedValue));
    }

    private void setupPixelGridSection() {
        boolean gridEnabled = pixelGridEnabled.get();
        pixelGridView.setChecked(gridEnabled);
        pixelRatioView.setEnabled(gridEnabled);
        pixelGridView.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Timber.d("Setting pixel grid overlay enabled to %b", isChecked);
            pixelGridEnabled.set(isChecked);
            pixelRatioView.setEnabled(isChecked);
        });

        pixelRatioView.setChecked(pixelRatioEnabled.get());
        pixelRatioView.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Timber.d("Setting pixel scale overlay enabled to %b", isChecked);
            pixelRatioEnabled.set(isChecked);
        });
    }

    private void setupScalpelSection() {
        scalpelView.setChecked(scalpelEnabled.get());
        scalpelWireframeView.setEnabled(scalpelEnabled.get());
        scalpelView.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Timber.d("Setting scalpel interaction enabled to %b", isChecked);
            scalpelEnabled.set(isChecked);
            scalpelWireframeView.setEnabled(isChecked);
        });

        scalpelWireframeView.setChecked(scalpelWireframeEnabled.get());
        scalpelWireframeView.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Timber.d("Setting scalpel wireframe enabled to %b", isChecked);
            scalpelWireframeEnabled.set(isChecked);
        });
    }

    @OnClick(R.id.debug_logs_show)
    void showLogs() {
        new LogsDialog(new ContextThemeWrapper(getContext(), R.style.Theme_StarterApp), lumberYard).show();
    }

    @OnClick(R.id.debug_leaks_show)
    void showLeaks() {
        Intent intent = new Intent(getContext(), DisplayLeakActivity.class);
        getContext().startActivity(intent);
    }

    private void setupBuildSection() {
        buildNameView.setText(BuildConfig.VERSION_NAME);
        buildCodeView.setText(String.valueOf(BuildConfig.VERSION_CODE));
        buildShaView.setText(BuildConfig.GIT_SHA);

        TemporalAccessor buildTime = Instant.ofEpochSecond(BuildConfig.GIT_TIMESTAMP);
        buildDateView.setText(DATE_DISPLAY_FORMAT.format(buildTime));
    }

    private void setupDeviceSection() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        String densityBucket = getDensityString(displayMetrics);
        deviceMakeView.setText(truncateAt(Build.MANUFACTURER, 20));
        deviceModelView.setText(truncateAt(Build.MODEL, 20));
        deviceResolutionView.setText(displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        deviceDensityView.setText(displayMetrics.densityDpi + "dpi (" + densityBucket + ")");
        deviceReleaseView.setText(Build.VERSION.RELEASE);
        deviceApiView.setText(String.valueOf(Build.VERSION.SDK_INT));
    }

    private void setupPicassoSection() {
        boolean picassoDebuggingValue = picassoDebugging.get();
        picasso.setIndicatorsEnabled(picassoDebuggingValue);
        picassoIndicatorsView.setChecked(picassoDebuggingValue);
        picassoIndicatorsView.setOnCheckedChangeListener((button, isChecked) -> {
            Timber.d("Setting Picasso debugging to " + isChecked);
            picasso.setIndicatorsEnabled(isChecked);
            picassoDebugging.set(isChecked);
        });

        refreshPicassoStats();
    }

    private void refreshPicassoStats() {
        StatsSnapshot snapshot = picasso.getSnapshot();
        String size = getSizeString(snapshot.size);
        String total = getSizeString(snapshot.maxSize);
        int percentage = (int) ((1f * snapshot.size / snapshot.maxSize) * 100);
        picassoCacheSizeView.setText(size + " / " + total + " (" + percentage + "%)");
        picassoCacheHitView.setText(String.valueOf(snapshot.cacheHits));
        picassoCacheMissView.setText(String.valueOf(snapshot.cacheMisses));
        picassoDecodedView.setText(String.valueOf(snapshot.originalBitmapCount));
        picassoDecodedTotalView.setText(getSizeString(snapshot.totalOriginalBitmapSize));
        picassoDecodedAvgView.setText(getSizeString(snapshot.averageOriginalBitmapSize));
        picassoTransformedView.setText(String.valueOf(snapshot.transformedBitmapCount));
        picassoTransformedTotalView.setText(getSizeString(snapshot.totalTransformedBitmapSize));
        picassoTransformedAvgView.setText(getSizeString(snapshot.averageTransformedBitmapSize));
    }

    private void setupOkHttpCacheSection() {
        Cache cache = client.cache(); // Shares the cache with apiClient, so no need to check both.
        okHttpMaxCacheSizeView.setText(getSizeString(cache.maxSize()));

        refreshOkHttpCacheStats();
    }

    private void refreshOkHttpCacheStats() {
        Cache cache = client.cache(); // Shares the cache with apiClient, so no need to check both.
        int writeTotal = cache.writeSuccessCount() + cache.writeAbortCount();
        int percentage = (int) ((1f * cache.writeAbortCount() / writeTotal) * 100);
        okHttpWriteErrorView.setText(
                cache.writeAbortCount() + " / " + writeTotal + " (" + percentage + "%)");
        okHttpRequestCountView.setText(String.valueOf(cache.requestCount()));
        okHttpNetworkCountView.setText(String.valueOf(cache.networkCount()));
        okHttpCacheHitCountView.setText(String.valueOf(cache.hitCount()));
    }

    private void applyAnimationSpeed(int multiplier) {
        try {
            Method method = ValueAnimator.class.getDeclaredMethod("setDurationScale", float.class);
            method.invoke(null, (float) multiplier);
        } catch (Exception e) {
            throw new RuntimeException("Unable to apply animation speed.", e);
        }
    }

    private void showCustomEndpointDialog(final int originalSelection, String defaultUrl) {
        View view = LayoutInflater.from(app).inflate(R.layout.debug_drawer_network_endpoint_dialog, null);
        final EditText url = findById(view, R.id.debug_drawer_network_endpoint_url);
        url.setText(defaultUrl);
        url.setSelection(url.length());

        new AlertDialog.Builder(getContext()) //
                .setTitle("Set Network Endpoint")
                .setView(view)
                .setNegativeButton("Cancel", (dialog, i) -> {
                    endpointSpinner.setSelection(originalSelection);
                    dialog.cancel();
                })
                .setPositiveButton("Use", (dialog, i) -> {
                    String theUrl = url.getText().toString();
                    if (!Strings.isBlank(theUrl)) {
                        setEndpointAndRelaunch(theUrl);
                    } else {
                        endpointSpinner.setSelection(originalSelection);
                    }
                })
                .setOnCancelListener((dialogInterface) -> {
                    endpointSpinner.setSelection(originalSelection);
                })
                .show();
    }

    private void setEndpointAndRelaunch(String endpointUrl) {
        Timber.d("Setting network endpoint to %s", endpointUrl);
        networkEndpoint.set(endpointUrl);

        ProcessPhoenix.triggerRebirth(getContext());
    }

    private String getDensityString(DisplayMetrics displayMetrics) {
        switch (displayMetrics.densityDpi) {
            case DisplayMetrics.DENSITY_LOW:
                return "ldpi";
            case DisplayMetrics.DENSITY_MEDIUM:
                return "mdpi";
            case DisplayMetrics.DENSITY_HIGH:
                return "hdpi";
            case DisplayMetrics.DENSITY_XHIGH:
                return "xhdpi";
            case DisplayMetrics.DENSITY_XXHIGH:
                return "xxhdpi";
            case DisplayMetrics.DENSITY_XXXHIGH:
                return "xxxhdpi";
            case DisplayMetrics.DENSITY_TV:
                return "tvdpi";
            default:
                return String.valueOf(displayMetrics.densityDpi);
        }
    }

    private String truncateAt(String string, int length) {
        return string.length() > length ? string.substring(0, length) : string;
    }

    private static String getSizeString(long bytes) {
        String[] units = new String[] { "B", "KB", "MB", "GB" };
        int unit = 0;
        while (bytes >= 1024) {
            bytes /= 1024;
            unit += 1;
        }
        return bytes + units[unit];
    }
}
