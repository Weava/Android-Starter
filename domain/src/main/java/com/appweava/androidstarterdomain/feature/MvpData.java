package com.appweava.androidstarterdomain.feature;

import com.google.auto.value.AutoValue;

/**
 * MvpModel
 * <p>
 * Simple POJO containing data for an MVP object.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
@AutoValue
public abstract class MvpData {

    public static Builder builder() {
        return new AutoValue_MvpData.Builder();
    }

    public abstract String someField();

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder someField(String someField);
        public abstract MvpData build();
    }
}
