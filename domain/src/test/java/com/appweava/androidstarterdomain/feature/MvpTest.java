package com.appweava.androidstarterdomain.feature;

import com.appweava.androidstarterdomain.interactor.BaseUseCaseTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * MvpTest
 * <p>
 * Class description here
 */
public class MvpTest extends BaseUseCaseTest {

    private MvpUseCase mvpUseCase;

    @Mock private MvpRepository mockMvpRepository;

    @Before
    public void setUp() {
        super.setUp();
        mvpUseCase = new MvpUseCase(transformerManager, mockMvpRepository);
    }

    @Test
    public void tesMvpUseCaseObservable() {
        mvpUseCase.buildUseCaseObservable();

        verify(mockMvpRepository).getMvpModelList();
        verifyNoMoreInteractions(mockMvpRepository);
    }
}
