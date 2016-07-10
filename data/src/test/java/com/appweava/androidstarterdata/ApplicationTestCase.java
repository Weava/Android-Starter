package com.appweava.androidstarterdata;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * ApplicationTestCase
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 7/9/16
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(
    constants = BuildConfig.class,
    application = ApplicationStub.class,
    sdk = 21
)
public abstract class ApplicationTestCase {}
