package com.appweava.androidstarter.presentation.feature;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * MvpActivityTest
 * <p>
 * Tests for {@link MvpActivity} class.
 */
@RunWith(AndroidJUnit4.class)
public class MvpActivityTest {

    public MvpActivityTest() {}

    @Rule
    public ActivityTestRule<MvpActivity> activityRule =
            new ActivityTestRule<>(MvpActivity.class, true, false);

    @Test
    public void testContainsProperTitle() {
        activityRule.launchActivity(new Intent());

        String actualTitle = activityRule.getActivity().getTitle().toString().trim();

        assertThat(actualTitle, is("Android Starter"));
    }
}
