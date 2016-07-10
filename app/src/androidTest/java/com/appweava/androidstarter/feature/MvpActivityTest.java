package com.appweava.androidstarter.feature;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;

import com.appweava.androidstarter.feature.view.MvpActivity;

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
public class MvpActivityTest extends ActivityInstrumentationTestCase2<MvpActivity> {

    private MvpActivity mvpActivity;

    public MvpActivityTest() {
        super(MvpActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        this.setActivityIntent(createTargetIntent());
        this.mvpActivity = getActivity();
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testContainsProperTitle() {
        String actualTitle = this.mvpActivity.getTitle().toString().trim();

        assertThat(actualTitle, is("Android Starter"));
    }

    private Intent createTargetIntent() {
        Intent intent = MvpActivity.getCallingIntent(getInstrumentation().getTargetContext());

        return intent;
    }
}
