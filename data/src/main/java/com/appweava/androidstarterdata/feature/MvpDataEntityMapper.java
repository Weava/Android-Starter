package com.appweava.androidstarterdata.feature;

import com.appweava.androidstarterdata.mapper.EntityMapper;
import com.appweava.androidstarterdomain.feature.MvpModel;

import java.util.ArrayList;
import java.util.List;

/**
 * MvpDataEntityMapper
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public class MvpDataEntityMapper implements EntityMapper<MvpDataEntity, MvpModel> {

    @Override
    public MvpModel transform(MvpDataEntity entity) {
        if (entity != null) {
            MvpModel mvpModel = new MvpModel(entity.getSomeField());
            return mvpModel;
        }
        throw new IllegalArgumentException("Entity must not be null");
    }

    @Override
    public List<MvpModel> transform(List<MvpDataEntity> entities) {
        if (entities != null && entities.size() > 0) {
            List<MvpModel> mvpModelList = new ArrayList<>();

            for (MvpDataEntity mvpDataEntity : entities) {
                mvpModelList.add(this.transform(mvpDataEntity));
            }

            return mvpModelList;
        }

        throw new IllegalArgumentException("Entity list must not be null");
    }
}
