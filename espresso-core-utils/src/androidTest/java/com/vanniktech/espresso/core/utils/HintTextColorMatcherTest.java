package com.vanniktech.espresso.core.utils;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.vanniktech.espresso.core.utils.test.R;
import junit.framework.AssertionFailedError;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.vanniktech.espresso.core.utils.HintTextColorMatcher.withHintTextColor;
import static com.vanniktech.espresso.core.utils.HintTextColorMatcher.withHintTextColorRes;
import static com.vanniktech.espresso.core.utils.HintTextColorMatcherActivity.VIEW_ID;

@RunWith(AndroidJUnit4.class) public final class HintTextColorMatcherTest {
  @Rule public final ExpectedException expectedException = ExpectedException.none();

  @Rule public final ActivityTestRule<HintTextColorMatcherActivity> activityTestRule = new ActivityTestRule<>(HintTextColorMatcherActivity.class);

  @Test public void withHintTextColorResMatches() {
    onView(withId(VIEW_ID)).check(matches(withHintTextColorRes(R.color.red)));
  }

  @Test public void withHintTextColorMatches() {
    onView(withId(VIEW_ID)).check(matches(withHintTextColor(RED)));
  }

  @Test public void withHintTextColorStringMatches() {
    onView(withId(VIEW_ID)).check(matches(withHintTextColor("#ff0000")));
  }

  @Test public void withHintTextColorResDoesNotMatch() {
    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with hint text color: ' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withHintTextColorRes(R.color.green)));
  }

  @Test public void withHintTextColorDoesNotMatch() {
    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with hint text color: ' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withHintTextColor(GREEN)));
  }

  @Test public void withHintTextColorStringDoesNotMatch() {
    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with hint text color: ' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withHintTextColor("#00ff00")));
  }
}
