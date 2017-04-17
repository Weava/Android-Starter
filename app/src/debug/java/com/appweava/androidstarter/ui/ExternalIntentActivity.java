package com.appweava.androidstarter.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import com.appweava.androidstarter.R;
import com.appweava.androidstarter.debug.Intents;

import java.lang.reflect.Field;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class ExternalIntentActivity extends Activity implements Toolbar.OnMenuItemClickListener {

    public static final String ACTION = "intent.EXTERNAL_INTENT";
    public static final String EXTRA_BASE_INTENT = "debug_base_intent";

    public static Intent getCallingIntent(Intent baseIntent) {
        Intent intent = new Intent();
        intent.setAction(ACTION);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(EXTRA_BASE_INTENT, baseIntent);
        return intent;
    }

    @BindView(R.id.toolbar) Toolbar toolbarView;
    @BindView(R.id.action) TextView actionView;
    @BindView(R.id.data) TextView dataView;
    @BindView(R.id.extras) TextView extrasView;
    @BindView(R.id.flags) TextView flagsView;

    private Intent baseIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debug_external_intent_activity);
        ButterKnife.bind(this);

        toolbarView.inflateMenu(R.menu.debug_external_intent);
        toolbarView.setOnMenuItemClickListener(this);

        baseIntent = getIntent().getParcelableExtra(EXTRA_BASE_INTENT);
        fillAction();
        fillData();
        fillExtras();
        fillFlags();
    }

    @Override public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.debug_launch:
                if (Intents.maybeStartActivity(this, baseIntent)) {
                    finish();
                }
                return true;
            default:
                return false;
        }
    }

    private void fillAction() {
        String action = baseIntent.getAction();
        actionView.setText(action == null ? "None!" : action);
    }

    private void fillData() {
        Uri data = baseIntent.getData();
        dataView.setText(data == null ? "None!" : data.toString());
    }

    private void fillExtras() {
        Bundle extras = baseIntent.getExtras();
        if (extras == null) {
            extrasView.setText("None!");
        } else {
            StringBuilder extrasBuilder = new StringBuilder();
            for (String key : extras.keySet()) {
                Object value = extras.get(key);

                String valueString;
                if (value.getClass().isArray()) {
                    valueString = Arrays.toString((Object[]) value);
                } else {
                    valueString = value.toString();
                }

                extrasBuilder.append(key)
                        .append(":\n")
                        .append(valueString)
                        .append("\n\n");
            }

            extrasView.setText(extrasBuilder.toString());
        }
    }

    private void fillFlags() {
        int flags = baseIntent.getFlags();

        StringBuilder builder = new StringBuilder();
        for (Field field : Intent.class.getDeclaredFields()) {
            try {
                if (field.getName().startsWith("FLAG_")
                        && field.getType() == Integer.TYPE
                        && (flags & field.getInt(null)) != 0) {
                    builder.append(field.getName()).append('\n');
                }
            } catch (IllegalAccessException e) {
                Timber.e(e, "Couldn't read value for: %s", field.getName());
            }
        }

        flagsView.setText(builder.length() == 0 ? "None!" : builder.toString());
    }
}
