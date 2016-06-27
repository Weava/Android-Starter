package com.appweava.androidstarter.internal.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * ActivityScope
 * <p>
 * Scoping annotation to conform dependencies to an activity specific lifetime.
 *
 * @author <a href="mailto:aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 6/26/16
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {}
