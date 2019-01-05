package com.vanniktech.espresso.core.utils;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import junit.framework.AssertionFailedError;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.vanniktech.espresso.core.utils.ProgressBarActivity.VIEW_ID;
import static com.vanniktech.espresso.core.utils.ProgressMatcher.withProgress;

@RunWith(AndroidJUnit4.class) public final class ProgressMatcherTest {
  @Rule public final ExpectedException expectedException = ExpectedException.none();

  @Rule public final ActivityTestRule<ProgressBarActivity> activityTestRule = new ActivityTestRule<>(ProgressBarActivity.class);

  @Test public void withProgressMatches() {
    onView(withId(VIEW_ID)).check(matches(withProgress(1)));
  }

  @Test public void withProgressDoesNotMatch() {
    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'has progress: <2>' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withProgress(2)));
  }
}
