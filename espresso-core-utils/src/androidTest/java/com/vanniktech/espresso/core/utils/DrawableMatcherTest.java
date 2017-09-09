package com.vanniktech.espresso.core.utils;

import android.support.annotation.DrawableRes;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.vanniktech.espresso.core.utils.test.R;
import junit.framework.AssertionFailedError;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.view.View.GONE;
import static com.vanniktech.espresso.core.utils.DrawableMatcher.withDrawable;
import static com.vanniktech.espresso.core.utils.DrawableMatcher.withNoDrawable;
import static com.vanniktech.espresso.core.utils.DrawableMatcherActivity.VIEW_ID;

@RunWith(AndroidJUnit4.class) public final class DrawableMatcherTest {
  @Rule public final ExpectedException expectedException = ExpectedException.none();

  @Rule public final ActivityTestRule<DrawableMatcherActivity> activityTestRule = new ActivityTestRule<>(DrawableMatcherActivity.class);

  @Test public void withNoDrawableMatches() {
    onView(withId(VIEW_ID)).check(matches(withNoDrawable()));
  }

  @Test public void withDrawableMatches() throws Throwable {
    setDrawable(R.drawable.android);

    onView(withId(VIEW_ID)).check(matches(withDrawable(R.drawable.android)));
  }

  @Test public void withNoDrawableDoesNotMatchOnGone() throws Throwable {
    setVisibility(GONE);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with no drawable' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withNoDrawable()));
  }

  @Test public void withDrawableDoesNotMatchOnGone() throws Throwable {
    setDrawable(R.drawable.android);
    setVisibility(GONE);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with drawable from resource id: <" + R.drawable.android + ">' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withDrawable(R.drawable.android)));
  }

  @Test public void withNoDrawableDoesNotMatch() throws Throwable {
    setDrawable(R.drawable.android);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with no drawable' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withNoDrawable()));
  }

  @Test public void withDrawableDoesNotMatch() throws Throwable {
    setDrawable(R.drawable.android);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with drawable from resource id: <" + R.drawable.northern_lights + ">' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withDrawable(R.drawable.northern_lights)));
  }

  private void setDrawable(@DrawableRes final int drawable) throws Throwable {
    activityTestRule.runOnUiThread(new Runnable() {
      @Override public void run() {
        activityTestRule.getActivity().imageView.setImageResource(drawable);
      }
    });
  }

  // Has to be package private because of https://github.com/pmd/pmd/issues/613.
  void setVisibility(final int visibility) throws Throwable {
    activityTestRule.runOnUiThread(new Runnable() {
      @Override public void run() {
        activityTestRule.getActivity().imageView.setVisibility(visibility);
      }
    });
  }
}
