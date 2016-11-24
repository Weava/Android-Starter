package com.appweava.androidstarterdomain.feature;

import com.appweava.androidstarterdomain.executor.ExecutionThread;
import com.appweava.androidstarterdomain.executor.PostExecutionThread;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * MvpTest
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 7/9/16
 */
public class MvpTest {

    private MvpUseCase mvpUseCase;

    @Mock private ExecutionThread mockExecutionThread;
    @Mock private PostExecutionThread mockPostExecutionThread;
    @Mock private MvpRepository mockMvpRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mvpUseCase = new MvpUseCase(mockExecutionThread, mockPostExecutionThread, mockMvpRepository);
    }

    @Test
    public void tesMvpUseCaseObservable() {
        mvpUseCase.buildUseCaseObservable();

        verify(mockMvpRepository).getMvpModelList();
        verifyNoMoreInteractions(mockMvpRepository);
        verifyZeroInteractions(mockExecutionThread);
        verifyZeroInteractions(mockPostExecutionThread);
    }
}
