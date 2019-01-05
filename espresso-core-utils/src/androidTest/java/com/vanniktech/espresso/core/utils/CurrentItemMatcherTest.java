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
import static com.vanniktech.espresso.core.utils.CurrentItemMatcher.withCurrentItem;
import static com.vanniktech.espresso.core.utils.TextColorMatcherActivity.VIEW_ID;

@RunWith(AndroidJUnit4.class) public final class CurrentItemMatcherTest {
  @Rule public final ExpectedException expectedException = ExpectedException.none();

  @Rule public final ActivityTestRule<CurrentItemMatcherActivity> activityTestRule = new ActivityTestRule<>(CurrentItemMatcherActivity.class);

  @Test public void withCurrentItemMatches() {
    onView(withId(VIEW_ID)).check(matches(withCurrentItem(0)));
  }

  @Test public void withCurrentItemDoesNotMatch() {
    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'has currentItem: <1>' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withCurrentItem(1)));
  }
}
