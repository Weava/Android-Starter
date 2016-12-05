package com.appweava.androidstarter.feature;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * MvpActivityTest
 * <p>
 * Class description here
 *
 * @author <a href="aaron@appweava.com">Aaron Weaver</a>
 * @version 1.0.0
 * @since 7/10/16
 */
@RunWith(AndroidJUnit4.class)
public class MvpActivityTest {

    @Rule
    public ActivityTestRule<MvpActivity> activityRule =
            new ActivityTestRule<>(MvpActivity.class, true, false);

    @Before
    public void setUp() {
//        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
//        StarterTestApp app = (StarterTestApp) instrumentation.getTargetContext().getApplicationContext();
//
//        app.getTestComponent().inject(this);
    }

    @Test
    public void testContainsProperTitle() {
        activityRule.launchActivity(new Intent());

        String actualTitle = activityRule.getActivity().getTitle().toString().trim();

        assertThat(actualTitle, is("Android Starter"));
    }
}