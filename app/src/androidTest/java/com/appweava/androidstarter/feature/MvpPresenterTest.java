package com.appweava.androidstarter.feature;

import android.support.test.runner.AndroidJUnit4;

import com.appweava.androidstarterdomain.feature.MvpUseCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
@RunWith(AndroidJUnit4.class)
public class MvpPresenterTest {

    private MvpPresenter mvpPresenter;

    @Mock private MvpView mockMvpView;
    @Mock private MvpUseCase mockMvpUseCase;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mvpPresenter = new MvpPresenter(mockMvpUseCase);
        mvpPresenter.attachView(mockMvpView);
    }

    @Test
    public void testGetMvpList() {

        mvpPresenter.getMvpList();

        verify(mockMvpUseCase).execute(any(Subscriber.class));
    }
}
