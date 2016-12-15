package com.appweava.androidstarterdata.feature;

import com.appweava.androidstarterdata.ApplicationTestCase;
import com.appweava.androidstarterdata.feature.repository.MvpDataRepository;
import com.appweava.androidstarterdata.feature.repository.MvpDataStore;
import com.appweava.androidstarterdata.feature.repository.MvpDataStoreFactory;
import com.appweava.androidstarterdomain.feature.MvpData;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * MvpRepositoryTest
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 7/9/16
 */
public class MvpRepositoryTest extends ApplicationTestCase {

    private MvpDataRepository mvpDataRepository;

    @Mock private MvpDataStoreFactory mockDataStoreFactory;
    @Mock private MvpDataStore mockDataStore;
    @Mock private MvpData mockMvp;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mvpDataRepository = new MvpDataRepository(mockDataStoreFactory);

        given(mockDataStoreFactory.create()).willReturn(mockDataStore);
        given(mockDataStoreFactory.createCloudStore()).willReturn(mockDataStore);
    }

    @Test
    public void testGetMvpListDataHappyCase() {
        List<MvpData> mvpDataEntities = new ArrayList<>();
        mvpDataEntities.add(MvpData.builder().someField("").build());
        given(mockDataStore.getMvpEntityList()).willReturn(Observable.just(mvpDataEntities));

        mvpDataRepository.getMvpModelList();

        verify(mockDataStoreFactory).create();
        verify(mockDataStore).getMvpEntityList();
    }
}
