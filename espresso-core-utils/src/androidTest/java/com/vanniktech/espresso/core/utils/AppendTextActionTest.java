package com.vanniktech.espresso.core.utils;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.vanniktech.espresso.core.utils.AppendTextAction.appendText;
import static com.vanniktech.espresso.core.utils.ProgressMatcherActivity.VIEW_ID;

@RunWith(AndroidJUnit4.class) public final class AppendTextActionTest {
  @Rule public final ActivityTestRule<AppendTextActionActivity> activityTestRule = new ActivityTestRule<>(AppendTextActionActivity.class);

  @Test public void appendingText() {
    onView(withId(VIEW_ID)).check(matches(withText("Test")));
    onView(withId(VIEW_ID)).perform(appendText("Something"));
    onView(withId(VIEW_ID)).check(matches(withText("TestSomething")));
  }
}
