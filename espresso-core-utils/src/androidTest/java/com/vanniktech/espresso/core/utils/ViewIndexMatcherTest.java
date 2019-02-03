package com.vanniktech.espresso.core.utils;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withTagValue;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.vanniktech.espresso.core.utils.ViewIndexMatcher.withIndex;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.fail;

@RunWith(AndroidJUnit4.class) public final class ViewIndexMatcherTest {
  @Rule public final ActivityTestRule<ViewIndexMatcherActivity> activityTestRule = new ActivityTestRule<>(ViewIndexMatcherActivity.class);

  @Test public void index() {
    onView(withIndex(withText("Test"), 0)).check(matches(withTagValue(Matchers.<Object>equalTo(1))));
    onView(withIndex(withText("Test"), 1)).check(matches(withTagValue(Matchers.<Object>equalTo(2))));
  }

  @Test public void invalidIndex() {
    try {
      onView(withIndex(withText("Test"), 2)).check(matches(withTagValue(Matchers.<Object>equalTo(1))));
      fail();
    } catch (final NoMatchingViewException e) {
      assertThat(e).hasMessageStartingWith("No views in hierarchy found matching: with index: <2> with text: is \"Test\"");
    }
  }
}
