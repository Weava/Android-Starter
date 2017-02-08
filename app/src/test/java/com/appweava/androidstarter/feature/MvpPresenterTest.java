package com.appweava.androidstarter.feature;

import com.appweava.androidstarterdomain.feature.MvpUseCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.functions.Action1;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * MvpPresenterTest
 * <p>
 * Class description here
 */
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

        verify(mockMvpUseCase).execute(any(Action1.class));
    }
}
