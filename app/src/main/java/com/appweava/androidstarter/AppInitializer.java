package com.appweava.androidstarter;

/**
 * AppInitializer
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 11/19/16
 */
public abstract class AppInitializer {

    public void init(StarterApp app) {
        initAppDependencies(app);
    }

    protected abstract void initAppDependencies(StarterApp app);
}
