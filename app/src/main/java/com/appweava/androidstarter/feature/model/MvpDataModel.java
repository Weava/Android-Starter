package com.appweava.androidstarter.feature.model;

/**
 * MvpModel
 * <p>
 * Class description here
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
