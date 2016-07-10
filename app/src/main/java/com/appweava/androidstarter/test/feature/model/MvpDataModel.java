package com.appweava.androidstarter.test.feature.model;

import com.appweava.androidstarterdomain.feature.MvpData;

/**
 * MvpModel
 * <p>
 * A POJO containing information for a {@link MvpData} in the presentation layer.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 7/6/16
 */
public class MvpDataModel {

    private String someField;

    public MvpDataModel(String someField) {
        this.someField = someField;
    }

    public String getSomeField() {
        return someField;
    }

    public void setSomeField(String someField) {
        this.someField = someField;
    }
}
