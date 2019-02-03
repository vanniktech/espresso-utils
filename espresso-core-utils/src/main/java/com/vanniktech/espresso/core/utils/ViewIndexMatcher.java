package com.vanniktech.espresso.core.utils;

import android.view.View;
import androidx.annotation.CheckResult;
import androidx.test.espresso.matcher.BoundedMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public final class ViewIndexMatcher extends BoundedMatcher<View, View> {
  /**
   * Matches the given matcher on the given index. This can be used when you have a Matcher<View> that matches multiple views.
   * By default Espresso will throw an exception on ambiguous views that can be matched.
   *
   * <p>Example usage:</p>
   * <code>onView(withIndex(withId(R.id.view), 2)).check(matches(withProgress(2)));</code>
   */
  @CheckResult public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
    return new ViewIndexMatcher(matcher, index);
  }

  private int currentIndex;

  private final Matcher<View> matcher;
  private final int index;

  private ViewIndexMatcher(final Matcher<View> matcher, final int index) {
    super(View.class);

    this.matcher = matcher;
    this.index = index;
  }

  @Override public void describeTo(final Description description) {
    description.appendText("with index: ");
    description.appendValue(index);
    description.appendText(" ");
    matcher.describeTo(description);
  }

  @Override public boolean matchesSafely(final View view) {
    return matcher.matches(view) && currentIndex++ == index;
  }
}
