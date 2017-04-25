package com.appweava.androidstarter.data;

import com.squareup.moshi.JsonAdapter;

@com.ryanharter.auto.value.moshi.MoshiAdapterFactory
public abstract class MoshiAdapterFactory implements JsonAdapter.Factory {

    public static JsonAdapter.Factory create() {
        return new AutoValueMoshi_MoshiAdapterFactory();
    }
}
