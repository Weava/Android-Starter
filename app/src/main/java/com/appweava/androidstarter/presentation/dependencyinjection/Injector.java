package com.appweava.androidstarter.presentation.dependencyinjection;

import com.appweava.androidstarter.presentation.dependencyinjection.component.AppComponent;

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
