package com.appweava.androidstarterdata.feature;

import com.appweava.androidstarterdata.ApplicationTestCase;
import com.appweava.androidstarterdata.feature.net.MvpApi;
import com.appweava.androidstarterdata.feature.repository.CloudMvpDataStore;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * CloudMvpDataStoreTest
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 7/10/16
 */
public class CloudMvpDataStoreTest extends ApplicationTestCase {

    private CloudMvpDataStore mvpDataStore;

    @Mock private MvpApi mockApi;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mvpDataStore = new CloudMvpDataStore(mockApi);
    }

    @Test
    public void getMvpEntityListFromApi() {
        mvpDataStore.getMvpEntityList();
        verify(mockApi).getMvpEntityList();
    }
}
