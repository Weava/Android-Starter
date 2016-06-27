package com.appweava.androidstarterdomain.feature;

/**
 * MvpModel
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
public class MvpModel {

    private String someField;

    public MvpModel(String someField) {
        this.someField = someField;
    }

    public String getSomeField() {
        return someField;
    }

    public void setSomeField(String someField) {
        this.someField = someField;
    }
}
