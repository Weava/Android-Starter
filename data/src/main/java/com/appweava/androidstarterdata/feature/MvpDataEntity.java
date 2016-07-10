package com.appweava.androidstarterdata.feature;

import com.appweava.androidstarterdomain.feature.MvpData;

/**
 * MvpDataEntity
 * <p>
 * Representation of {@link MvpData} for the data layer.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public class MvpDataEntity {

    private String someField;

    public MvpDataEntity(String someField) {
        this.someField = someField;
    }

    public String getSomeField() {
        return someField;
    }

    public void setSomeField(String someField) {
        this.someField = someField;
    }
}
