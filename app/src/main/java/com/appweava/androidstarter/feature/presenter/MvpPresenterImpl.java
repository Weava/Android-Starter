package com.appweava.androidstarter.feature.presenter;

import android.support.annotation.NonNull;

import com.appweava.androidstarter.feature.model.MvpDataModel;
import com.appweava.androidstarter.feature.model.MvpDataModelMapper;
import com.appweava.androidstarter.feature.view.MvpView;
import com.appweava.androidstarter.internal.di.PerActivity;
import com.appweava.androidstarterdomain.feature.MvpData;
import com.appweava.androidstarterdomain.interactor.UseCase;
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
@PerActivity
public class MvpPresenterImpl implements MvpPresenter, RxCallback<List<MvpData>> {

    private MvpView mvpView;
    private UseCase mvpUseCase;
    private MvpDataModelMapper modelMapper;

    @Inject
    public MvpPresenterImpl(UseCase useCase, MvpDataModelMapper mapper) {
        this.mvpUseCase = useCase;
        modelMapper = mapper;
    }

    /**
     * Set the view this presenter will present to.
     *
     * @param mvpView
     *      The view to be set
     */
    public void setView(@NonNull MvpView mvpView) {
        mvpView = mvpView;
    }

    @Override
    public void resume() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void getMvpList() {
        mvpUseCase.execute(new RxSubscriber<>(this));
    }

    @Override
    public void onDataReady(List<MvpData> data) {
        List<MvpDataModel> mvpDataModels = modelMapper.transformFromDomain(data);
        for (MvpDataModel mvpModel : mvpDataModels) {
            Timber.tag("Mvp Activity").i("Model: %s", mvpModel.getSomeField());
        }
    }

    @Override
    public void onDataError(Throwable t) {
        Timber.tag("Mvp Activity Error").e("%s", t.getMessage());
    }
}
