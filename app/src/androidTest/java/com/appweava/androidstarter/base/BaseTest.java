package com.appweava.androidstarter.base;

import com.appweava.androidstarter.rxespresso.RxEspresso;

import org.junit.After;

import timber.log.Timber;

/**
 * BaseTest
 * <p>
 * Class description here
 */
public abstract class BaseTest {

    @After
    public void tearDown() throws Exception {
        // if there is anything still idling then future tests may fail
        boolean idleNow = RxEspresso.isIdleNow();

        if (!idleNow) {
            Timber.tag("TESTING").e("Test is over but RxEspresso is not idle. Remaining tests may fail unexpectedly.");
            System.exit(-1);
        }
    }
}
