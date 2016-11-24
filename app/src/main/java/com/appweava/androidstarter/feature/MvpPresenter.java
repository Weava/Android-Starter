package com.appweava.androidstarter.feature;

import com.appweava.androidstarter.base.mvp.BasePresenter;
import com.appweava.androidstarterdomain.feature.MvpData;
import com.appweava.androidstarterdomain.feature.MvpUseCase;
import com.appweava.androidstarterdomain.interactor.rx.RxCallback;
import com.appweava.androidstarterdomain.interactor.rx.RxSubscriber;

import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * MvpPresenterImpl
 * <p>
 * Implementation {@link MvpPresenter}.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public class MvpPresenter extends BasePresenter<MvpView> implements RxCallback<List<MvpData>> {

    private MvpUseCase mvpUseCase;

    @Inject
    public MvpPresenter(MvpUseCase useCase) {
        this.mvpUseCase = useCase;
    }

    public void getMvpList() {
        mvpUseCase.execute(new RxSubscriber<>(this));
    }

    @Override
    public void onDataReady(List<MvpData> data) {
        for (MvpData mvpModel : data) {
            Timber.tag("Mvp Activity").i("Model: %s", mvpModel.getSomeField());
        }
    }

    @Override
    public void onDataError(Throwable t) {
        Timber.tag("Mvp Activity Error").e("%s", t.getMessage());
    }
}
