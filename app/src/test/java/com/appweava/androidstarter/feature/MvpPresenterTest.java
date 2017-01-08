package com.appweava.androidstarter.feature;

import com.appweava.androidstarterdomain.feature.MvpUseCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import rx.Subscription;
import rx.functions.Action1;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * MvpPresenterTest
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 7/10/16
 */
public class MvpPresenterTest {

    private MvpPresenter mvpPresenter;

    @Mock private MvpView mockMvpView;
    @Mock private MvpUseCase mockMvpUseCase;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mvpPresenter = new MvpPresenter(mockMvpUseCase);
        when(mockMvpUseCase.execute(any())).thenReturn(Mockito.mock(Subscription.class));
        mvpPresenter.attachView(mockMvpView);
    }

    @Test
    public void testGetMvpList() {
        mvpPresenter.getMvpList();

        verify(mockMvpUseCase).execute(any(Action1.class));
    }
}
