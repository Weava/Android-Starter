package com.appweava.androidstarter.feature;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * MvpPresenterTest
 * <p>
 * Class description here
 */
public class MvpPresenterTest {

    private MvpPresenter mvpPresenter;

    @Mock private MvpView mockMvpView;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mvpPresenter = new MvpPresenter();
        mvpPresenter.attachView(mockMvpView);
    }

    @Test
    public void testGetMvpList() {
        mvpPresenter.getMvpList();

        verify(mockMvpView).doSomeOtherViewStuff();
    }
}
