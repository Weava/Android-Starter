package com.appweava.androidstarter.test.feature;

import android.test.AndroidTestCase;

import com.appweava.androidstarter.test.feature.model.MvpDataModelMapper;
import com.appweava.androidstarter.test.feature.presenter.MvpPresenterImpl;
import com.appweava.androidstarter.test.feature.view.MvpView;
import com.appweava.androidstarterdomain.feature.MvpUseCase;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.Subscriber;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * MvpPresenterTest
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 7/10/16
 */
public class MvpPresenterTest extends AndroidTestCase {

    private MvpPresenterImpl mvpPresenter;

    @Mock private MvpView mockMvpView;
    @Mock private MvpUseCase mockMvpUseCase;
    @Mock private MvpDataModelMapper mockMapper;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
        mvpPresenter = new MvpPresenterImpl(mockMvpUseCase, mockMapper);
        mvpPresenter.setView(mockMvpView);
    }

    public void testGetMvpList() {
        mvpPresenter.getMvpList();

        verify(mockMvpUseCase).execute(any(Subscriber.class));
    }
}