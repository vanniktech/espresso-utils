package com.vanniktech.espresso.core.utils;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import junit.framework.AssertionFailedError;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.vanniktech.espresso.core.utils.ProgressMatcher.withProgress;
import static com.vanniktech.espresso.core.utils.ProgressMatcherActivity.VIEW_ID;

@RunWith(AndroidJUnit4.class) public final class ProgressMatcherTest {
  @Rule public final ExpectedException expectedException = ExpectedException.none();

  @Rule public final ActivityTestRule<ProgressMatcherActivity> activityTestRule = new ActivityTestRule<>(ProgressMatcherActivity.class);

  @Test public void withProgressMatches() {
    onView(withId(VIEW_ID)).check(matches(withProgress(1)));
  }

  @Test public void withProgressDoesNotMatch() {
    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'has progress: <2>' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withProgress(2)));
  }
}
