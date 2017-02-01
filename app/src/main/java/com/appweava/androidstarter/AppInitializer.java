package com.appweava.androidstarter;

/**
 * AppInitializer
 * <p>
 * Initializes application and it's dependencies.
 */
public abstract class AppInitializer {

    /**
     * Initializes the application.
     *
     * @param app
     *         {@link StarterApp}
     */
    public void init(StarterApp app) {
        initAppDependencies(app);
    }

    /**
     * Initializes application dependencies.
     *
     * @param app
     *         {@link StarterApp}
     */
    protected abstract void initAppDependencies(StarterApp app);
}
