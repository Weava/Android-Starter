package com.appweava.androidstarterdomain.interactor;

import com.appweava.androidstarterdomain.executor.ExecutionThread;
import com.appweava.androidstarterdomain.executor.PostExecutionThread;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.schedulers.TestScheduler;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * UseCaseTest
 * <p>
 * Class description here
 */
public class UseCaseTest {

    private UseCaseTestClass useCase;

    @Mock private ExecutionThread mockExecutionThread;
    @Mock private PostExecutionThread mockPostExecutionThread;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.useCase = new UseCaseTestClass(mockExecutionThread, mockPostExecutionThread);
    }

    @Test
    public void testBuildUseCaseObservableReturnCorrectResults() {
        TestScheduler testScheduler = new TestScheduler();
        given(mockPostExecutionThread.getScheduler()).willReturn(testScheduler);
        Action1<Integer> onNext = mock(Action1.class);

        useCase.execute(onNext);

        verify(onNext, times(0)).call(any());
    }

    @Test
    public void testSubscriptionWhenExecutingUseCase() {
        Subscription subscription = useCase.execute((item) -> {});

        assertThat(subscription.isUnsubscribed(), is(true));
    }

    private static class UseCaseTestClass extends UseCase {

        public UseCaseTestClass(ExecutionThread executionThread,
                PostExecutionThread postExecutionThread) {
            super(executionThread, postExecutionThread);
        }

        @Override
        protected Observable buildUseCaseObservable() {
            return Observable.empty();
        }

        @Override
        protected <T> Observable.Transformer<T, T> applySchedulers() {
            return observable -> observable
                    .observeOn(Schedulers.immediate())
                    .subscribeOn(Schedulers.immediate());
        }
    }
}
