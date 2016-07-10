package com.appweava.androidstarter.test.feature;

import com.appweava.androidstarter.test.feature.model.MvpDataModel;
import com.appweava.androidstarter.test.feature.model.MvpDataModelMapper;
import com.appweava.androidstarterdomain.feature.MvpData;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.mockito.Mockito.mock;

/**
 * MvpDataModelMapperTest
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 7/10/16
 */
public class MvpDataModelMapperTest extends TestCase {

    private static final String FAKE_SOME_FIELD = "someField";

    private MvpDataModelMapper mvpDataModelMapper;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        mvpDataModelMapper = new MvpDataModelMapper();
    }

    public void testTransformMvpData() {
        MvpData data = createFakeMvpData();
        MvpDataModel dataModel = mvpDataModelMapper.transformFromDomain(data);

        assertThat(dataModel, is(instanceOf(MvpDataModel.class)));
        assertThat(dataModel.getSomeField(), is(FAKE_SOME_FIELD));
    }

    public void testTransformMvpDataCollection() {
        MvpData dataOne = mock(MvpData.class);
        MvpData dataTwo = mock(MvpData.class);

        List<MvpData> mvpDataList = new ArrayList<>();
        mvpDataList.add(dataOne);
        mvpDataList.add(dataTwo);

        Collection<MvpDataModel> mvpDataModels =
                mvpDataModelMapper.transformFromDomain(mvpDataList);

        assertThat(mvpDataModels.toArray()[0], is(instanceOf(MvpDataModel.class)));
        assertThat(mvpDataModels.toArray()[1], is(instanceOf(MvpDataModel.class)));
        assertThat(mvpDataModels.size(), is(2));
    }

    private MvpData createFakeMvpData() {
        MvpData data = new MvpData(FAKE_SOME_FIELD);
        return data;
    }
}
