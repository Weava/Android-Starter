package com.appweava.androidstarter.feature.model;

import com.appweava.androidstarter.internal.di.PerActivity;
import com.appweava.androidstarterdata.mapper.EntityMapper;
import com.appweava.androidstarterdomain.feature.MvpData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * MvpModelMapper
 * <p>
 * Maps a {@link MvpData} to a {@link MvpDataModel} and vice versa.
 *
 * @see EntityMapper
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 7/6/16
 */
@PerActivity
public class MvpDataModelMapper implements EntityMapper<MvpDataModel, MvpData> {

    @Inject
    public MvpDataModelMapper() {}

    @Override
    public MvpData transformToDomain(MvpDataModel entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<MvpData> transformToDomain(List<MvpDataModel> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MvpDataModel transformFromDomain(MvpData entity) {
        if (entity != null) {
            MvpDataModel dataModel = new MvpDataModel(entity.getSomeField());
            return dataModel;
        }
        return null;
    }

    @Override
    public List<MvpDataModel> transformFromDomain(List<MvpData> entities) {
        if (entities != null && entities.size() > 0) {
            List<MvpDataModel> mvpModelList = new ArrayList<>();

            for (MvpData mvpData : entities) {
                mvpModelList.add(this.transformFromDomain(mvpData));
            }

            return mvpModelList;
        }

        throw new IllegalArgumentException("Entity list must not be null");
    }
}
