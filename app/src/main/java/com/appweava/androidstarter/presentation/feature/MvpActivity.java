package com.appweava.androidstarter.presentation.feature;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.appweava.androidstarter.R;
import com.appweava.androidstarter.data.feature.MvpData;
import com.appweava.androidstarter.presentation.base.ui.ViewContainer;
import com.appweava.androidstarter.presentation.dependencyinjection.Injector;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import timber.log.Timber;

/**
 * MvpActivity
 * <p>
 * Activity pertaining to mvp feature.
 */
public class MvpActivity extends Activity implements MvpContract.View {

    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, MvpActivity.class);
        return intent;
    }

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject MvpContract.Presenter presenter;
    @Inject
    ViewContainer viewContainer;

    private State currentViewState;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Injector.getInstance().getAppGraph().inject(this);
        ViewGroup container = viewContainer.forActivity(this);

        getLayoutInflater().inflate(R.layout.mvp_activity, container);
        unbinder = ButterKnife.bind(this, container);
        setActionBar(toolbar);

        presenter.attachView(this);
        presenter.getMvpList();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }

        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
    }

    @Override
    public void setMvpListForView(List<MvpData> mvpDataList) {
        setState(State.CONTENT);
    }

    @Override
    public void setState(State state) {
        if (currentViewState == null || state != currentViewState) {
            currentViewState = state;

            switch (state) {
                case LOADING:
                    Timber.i("State Loading");
                    break;
                case CONTENT:
                    Timber.i("State Content");
                    break;
            }
        }
    }
}
