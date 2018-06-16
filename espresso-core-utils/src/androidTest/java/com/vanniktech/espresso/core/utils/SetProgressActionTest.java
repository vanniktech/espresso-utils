package com.vanniktech.espresso.core.utils;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.vanniktech.espresso.core.utils.ProgressMatcher.withProgress;
import static com.vanniktech.espresso.core.utils.SetProgressAction.setProgress;
import static com.vanniktech.espresso.core.utils.ProgressBarActivity.VIEW_ID;

@RunWith(AndroidJUnit4.class) public final class SetProgressActionTest {
  @Rule public final ActivityTestRule<ProgressBarActivity> activityTestRule = new ActivityTestRule<>(ProgressBarActivity.class);

  @Test public void settingProgress() {
    onView(withId(VIEW_ID)).check(matches(withProgress(1)));
    onView(withId(VIEW_ID)).perform(setProgress(95));
    onView(withId(VIEW_ID)).check(matches(withProgress(95)));
  }
}
