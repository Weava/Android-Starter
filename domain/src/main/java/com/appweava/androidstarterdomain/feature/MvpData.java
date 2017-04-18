package com.appweava.androidstarterdomain.feature;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.Nullable;

/**
 * MvpModel
 * <p>
 * Simple POJO containing data for an MVP object.
 */
@AutoValue
public abstract class MvpData {

    public static Builder builder() {
        return new AutoValue_MvpData.Builder();
    }

    public abstract String someField();

    @Nullable
    public abstract String anotherField();

    public static JsonAdapter<MvpData> jsonAdapter(Moshi moshi) {
        return new AutoValue_MvpData.MoshiJsonAdapter(moshi);
    }

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder someField(String value);

        @Nullable
        public abstract Builder anotherField(String value);

        public abstract MvpData build();
    }
}
