package com.appweava.androidstarter.internal.di;

import com.appweava.androidstarter.internal.di.component.AppComponent;

public class Injector {

    private AppComponent appGraph;
    private static Injector instance;

    private Injector(AppComponent appGraph) {
        this.appGraph = appGraph;
    }

    public AppComponent getAppGraph() {
        return appGraph;
    }

    public static void init(AppComponent graph) {
        if (instance != null) {
            return;
        }

        instance = new Injector(graph);
    }

    public static Injector getInstance() {
        return instance;
    }
}
