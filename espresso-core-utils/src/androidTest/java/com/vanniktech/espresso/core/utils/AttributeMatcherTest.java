package com.vanniktech.espresso.core.utils;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.vanniktech.espresso.core.utils.test.R;
import junit.framework.AssertionFailedError;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.vanniktech.espresso.core.utils.AttributeMatcher.withAttr;
import static com.vanniktech.espresso.core.utils.AttributeMatcher.withAttrRes;
import static com.vanniktech.espresso.core.utils.AttributeMatcher.withColorAccent;
import static com.vanniktech.espresso.core.utils.AttributeMatcher.withColorAccentRes;
import static com.vanniktech.espresso.core.utils.AttributeMatcher.withColorButtonNormal;
import static com.vanniktech.espresso.core.utils.AttributeMatcher.withColorButtonNormalRes;
import static com.vanniktech.espresso.core.utils.AttributeMatcherActivity.VIEW_ID;

@RunWith(AndroidJUnit4.class) public final class AttributeMatcherTest {
  @Rule public final ExpectedException expectedException = ExpectedException.none();

  @Rule public final ActivityTestRule<AttributeMatcherActivity> activityTestRule = new ActivityTestRule<>(AttributeMatcherActivity.class);

  @Test public void withAttrResMatches() {
    onView(withId(VIEW_ID)).check(matches(withAttrRes(R.attr.colorError, R.color.blue)));
  }

  @Test public void withAttrMatches() {
    onView(withId(VIEW_ID)).check(matches(withAttr(R.attr.colorError, BLUE)));
  }

  @Test public void withAttrStringMatches() {
    onView(withId(VIEW_ID)).check(matches(withAttr(R.attr.colorError, "#0000ff")));
  }

  @Test public void withAttrResDoesNotMatch() {
    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with " + R.attr.colorError + ": ' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withAttrRes(R.attr.colorError, R.color.red)));
  }

  @Test public void withAttrDoesNotMatch() {
    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with " + R.attr.colorError + ": ' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withAttr(R.attr.colorError, RED)));
  }

  @Test public void withAttrStringDoesNotMatch() {
    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with " + R.attr.colorError + ": ' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withAttr(R.attr.colorError, "#ff0000")));
  }

  @Test public void withColorButtonNormalResMatches() {
    onView(withId(VIEW_ID)).check(matches(withColorButtonNormalRes(R.color.red)));
  }

  @Test public void withColorButtonNormalMatches() {
    onView(withId(VIEW_ID)).check(matches(withColorButtonNormal(RED)));
  }

  @Test public void withColorButtonNormalStringMatches() {
    onView(withId(VIEW_ID)).check(matches(withColorButtonNormal("#ff0000")));
  }

  @Test public void withColorButtonNormalResDoesNotMatch() {
    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with colorButtonNormal: ' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withColorButtonNormalRes(R.color.green)));
  }

  @Test public void withColorButtonNormalDoesNotMatch() {
    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with colorButtonNormal: ' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withColorButtonNormal(GREEN)));
  }

  @Test public void withColorButtonNormalStringDoesNotMatch() {
    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with colorButtonNormal: ' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withColorButtonNormal("#00ff00")));
  }

  @Test public void withColorAccentResMatches() {
    onView(withId(VIEW_ID)).check(matches(withColorAccentRes(R.color.green)));
  }

  @Test public void withColorAccentMatches() {
    onView(withId(VIEW_ID)).check(matches(withColorAccent(GREEN)));
  }

  @Test public void withColorAccentStringMatches() {
    onView(withId(VIEW_ID)).check(matches(withColorAccent("#00ff00")));
  }

  @Test public void withColorAccentResDoesNotMatch() {
    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with colorAccent: ' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withColorAccentRes(R.color.red)));
  }

  @Test public void withColorAccentDoesNotMatch() {
    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with colorAccent: ' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withColorAccent(RED)));
  }

  @Test public void withColorAccentStringDoesNotMatch() {
    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with colorAccent: ' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withColorAccent("#ff0000")));
  }
}
