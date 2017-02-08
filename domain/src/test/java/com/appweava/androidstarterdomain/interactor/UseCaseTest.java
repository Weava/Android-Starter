package com.appweava.androidstarterdomain.interactor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * UseCaseTest
 * <p>
 * Class description here
 */
public class UseCaseTest extends BaseUseCaseTest {

    private UseCaseTestClass useCase;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.useCase = new UseCaseTestClass(transformerManager);
    }

    @Test
    public void testBuildUseCaseObservableReturnCorrectResults() {
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

        public UseCaseTestClass(TransformerManager transformerManager) {
            super(transformerManager);
        }

        @Override
        protected Observable buildUseCaseObservable() {
            return Observable.empty();
        }
    }
}
