package com.appweava.androidstarter;

/**
 * AppInitializer
 * <p>
 * Initializes application and it's dependencies.
 */
public abstract class AppInitializer {

    /**
     * Initializes application dependencies.
     *
     * @param app
     *         {@link StarterApp}
     */
    protected abstract void initAppDependencies(StarterApp app);
}
