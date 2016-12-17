package com.appweava.androidstarter;

/**
 * AppInitializer
 * <p>
 * Initializes application and it's dependencies.
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/19/16
 */
public abstract class AppInitializer {

    /**
     * Initializes the application.
     *
     * @param app
     *      {@link StarterApp}
     */
    public void init(StarterApp app) {
        initAppDependencies(app);
    }

    /**
     * Initializes application dependencies.
     *
     * @param app
     *      {@link StarterApp}
     */
    protected abstract void initAppDependencies(StarterApp app);
}
