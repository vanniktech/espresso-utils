package com.vanniktech.espresso.core.utils;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import com.vanniktech.espresso.core.utils.test.R;
import junit.framework.AssertionFailedError;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.vanniktech.espresso.core.utils.TextColorMatcher.withTextColor;
import static com.vanniktech.espresso.core.utils.TextColorMatcher.withTextColorRes;
import static com.vanniktech.espresso.core.utils.TextColorMatcherActivity.VIEW_ID;

@RunWith(AndroidJUnit4.class) public final class TextColorMatcherTest {
  @Rule public final ExpectedException expectedException = ExpectedException.none();

  @Rule public final ActivityTestRule<TextColorMatcherActivity> activityTestRule = new ActivityTestRule<>(TextColorMatcherActivity.class);

  @Test public void withTextColorResMatches() {
    onView(withId(VIEW_ID)).check(matches(withTextColorRes(R.color.red)));
  }

  @Test public void withTextColorMatches() {
    onView(withId(VIEW_ID)).check(matches(withTextColor(RED)));
  }

  @Test public void withTextColorStringMatches() {
    onView(withId(VIEW_ID)).check(matches(withTextColor("#ff0000")));
  }

  @Test public void withTextColorResDoesNotMatch() {
    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with text color: ' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withTextColorRes(R.color.green)));
  }

  @Test public void withTextColorDoesNotMatch() {
    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with text color: ' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withTextColor(GREEN)));
  }

  @Test public void withTextColorStringDoesNotMatch() {
    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with text color: ' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withTextColor("#00ff00")));
  }
}
