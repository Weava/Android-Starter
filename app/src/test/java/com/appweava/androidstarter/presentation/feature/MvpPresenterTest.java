package com.appweava.androidstarter.presentation.feature;

import com.appweava.androidstarter.data.feature.MvpInteractor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * MvpPresenterTest
 * <p>
 * Class description here
 */
public class MvpPresenterTest {

    private MvpPresenter mvpPresenter;

    @Mock private MvpContract.View mockMvpView;
    @Mock private MvpInteractor mvpInteractor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mvpPresenter = new MvpPresenter(mvpInteractor);
        mvpPresenter.attachView(mockMvpView);
    }

    @Test
    public void testGetMvpList() {
        mvpPresenter.getMvpList();

        verify(mockMvpView).setMvpListForView(any());
    }
}
