package com.appweava.androidstarterdata.feature;

import com.appweava.androidstarterdomain.feature.MvpData;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.mockito.Mockito.mock;

/**
 * MvpDataEntityMapperTest
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 7/10/16
 */
public class MvpDataEntityMapperTest {

    private static final String SOME_FIELD_DATA = "Test";

    private MvpDataEntityMapper mapper;

    @Before
    public void setUp() {
        mapper = new MvpDataEntityMapper();
    }

    @Test
    public void testTransformMvpEntity() {
        MvpDataEntity entity = createFakeMvpEntity();
        MvpData mvpData = mapper.transformToDomain(entity);

        assertThat(mvpData, is(instanceOf(MvpData.class)));
        assertThat(mvpData.getSomeField(), is(SOME_FIELD_DATA));
    }

    @Test
    public void testTransformCollectionMvpEntity() {
        MvpDataEntity entityOne = mock(MvpDataEntity.class);
        MvpDataEntity entityTwo = mock(MvpDataEntity.class);

        List<MvpDataEntity> mvpDataEntities = new ArrayList<>();
        mvpDataEntities.add(entityOne);
        mvpDataEntities.add(entityTwo);

        Collection<MvpData> mvpDatasCollection = mapper.transformToDomain(mvpDataEntities);

        assertThat(mvpDatasCollection.toArray()[0], is(instanceOf(MvpData.class)));
        assertThat(mvpDatasCollection.toArray()[1], is(instanceOf(MvpData.class)));
        assertThat(mvpDatasCollection.size(), is(2));
    }

    private MvpDataEntity createFakeMvpEntity() {
        MvpDataEntity entity = new MvpDataEntity(SOME_FIELD_DATA);
        return entity;
    }
}
