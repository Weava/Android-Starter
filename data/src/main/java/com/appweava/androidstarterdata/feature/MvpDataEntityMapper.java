package com.appweava.androidstarterdata.feature;

import com.appweava.androidstarterdata.mapper.EntityMapper;
import com.appweava.androidstarterdomain.feature.MvpData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * MvpDataEntityMapper
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
@Singleton
public class MvpDataEntityMapper implements EntityMapper<MvpDataEntity, MvpData> {

    @Inject
    public MvpDataEntityMapper() {}

    @Override
    public MvpData transformToDomain(MvpDataEntity entity) {
        if (entity != null) {
            MvpData mvpModel = new MvpData(entity.getSomeField());
            return mvpModel;
        }
        throw new IllegalArgumentException("Entity must not be null");
    }

    @Override
    public List<MvpData> transformToDomain(List<MvpDataEntity> entities) {
        if (entities != null && entities.size() > 0) {
            List<MvpData> mvpModelList = new ArrayList<>();

            for (MvpDataEntity mvpDataEntity : entities) {
                mvpModelList.add(this.transformToDomain(mvpDataEntity));
            }

            return mvpModelList;
        }

        throw new IllegalArgumentException("Entity list must not be null");
    }

    @Override
    public MvpDataEntity transformFromDomain(MvpData model) {
         throw new UnsupportedOperationException();
    }

    @Override
    public List<MvpDataEntity> transformFromDomain(List<MvpData> models) {
        throw new UnsupportedOperationException();
    }
}
