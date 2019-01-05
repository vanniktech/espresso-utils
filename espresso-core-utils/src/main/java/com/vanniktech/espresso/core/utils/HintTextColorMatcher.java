package com.vanniktech.espresso.core.utils;

import android.graphics.Color;
import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.widget.TextView;
import org.hamcrest.Description;

public final class HintTextColorMatcher extends BoundedMatcher<View, TextView> {
  /**
   * Matches that the hint text has the expected color.
   *
   * <p>Example usage:</p>
   * <code>onView(withId(R.id.view)).check(matches(withHintTextColorRes(R.color.blue)));</code>
   */
  @CheckResult public static HintTextColorMatcher withHintTextColorRes(@ColorRes final int colorRes) {
    return new HintTextColorMatcher(ColorChecker.fromRes(colorRes));
  }

  /**
   * Matches that the hint text has the expected color.
   *
   * <p>Example usage:</p>
   * <code>onView(withId(R.id.view)).check(matches(withHintTextColorRes(BLUE)));</code>
   */
  @CheckResult public static HintTextColorMatcher withHintTextColor(@ColorInt final int color) {
    return new HintTextColorMatcher(ColorChecker.from(color));
  }

  /**
   * Matches that the hint text has the expected color.
   *
   * <p>Example usage:</p>
   * <code>onView(withId(R.id.view)).check(matches(withHintTextColorRes("#0000ff")));</code>
   */
  @CheckResult public static HintTextColorMatcher withHintTextColor(final String color) {
    return withHintTextColor(Color.parseColor(color));
  }

  private final ColorChecker colorChecker;

  private HintTextColorMatcher(final ColorChecker colorChecker) {
    super(TextView.class);

    this.colorChecker = colorChecker;
  }

  @Override protected boolean matchesSafely(final TextView item) {
    final int color = item.getCurrentHintTextColor();
    return colorChecker.matches(color, item.getContext());
  }

  @Override public void describeTo(final Description description) {
    description.appendText("with hint text color: ");
  }
}
