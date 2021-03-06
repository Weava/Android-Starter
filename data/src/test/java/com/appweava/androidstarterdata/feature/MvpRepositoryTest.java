package com.appweava.androidstarterdata.feature;

import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.appweava.androidstarterdata.feature.repository.MvpDataRepository;
import com.appweava.androidstarterdomain.feature.MvpData;
import com.appweava.androidstarterdomain.interactor.ObservableSchedulerManager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

/**
 * MvpRepositoryTest
 * <p>
 * Class description here
 */
public class MvpRepositoryTest {

    private MvpDataRepository mvpDataRepository;

    @Mock private MvpApi mvpApi;
    @Mock private MvpData mockMvp;
    @Mock private ObservableSchedulerManager observableSchedulerManager;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        List<MvpData> mvpDataEntities = new ArrayList<>();
        mvpDataEntities.add(MvpData.builder().someField("Test").build());
        when(mvpApi.getMvpEntityList()).thenReturn(Observable.just(mvpDataEntities));
        mvpDataRepository = new MvpDataRepository(mvpApi, observableSchedulerManager);
    }

    @Test
    public void testGetMvpListDataHappyCase() {
        List<MvpData> mvpDataEntities = new ArrayList<>();

        mvpDataRepository.getMvpModelList()
                         .subscribe(mvpDataEntities::addAll);

        assertThat(mvpDataEntities.size() > 0, is(true));
    }
}
