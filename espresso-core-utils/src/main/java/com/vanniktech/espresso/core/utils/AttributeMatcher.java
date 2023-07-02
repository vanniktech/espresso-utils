package com.vanniktech.espresso.core.utils;

import android.graphics.Color;
import androidx.annotation.AttrRes;
import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.widget.TextView;
import org.hamcrest.Description;

import static com.vanniktech.espresso.core.utils.Utils.resolveAttribute;

public final class AttributeMatcher extends BoundedMatcher<View, TextView> {
  /**
   * Matches that the given attribute has the expected color.
   *
   * <p>Example usage:</p>
   * <code>onView(withId(R.id.view)).check(matches(withAttrRes(R.attr.colorError, R.color.blue)));</code>
   */
  @CheckResult public static AttributeMatcher withAttrRes(@AttrRes final int attr, @ColorRes final int colorRes) {
    return new AttributeMatcher(attr, null, ColorChecker.fromRes(colorRes));
  }

  /**
   * Matches that the given attribute has the expected color.
   *
   * <p>Example usage:</p>
   * <code>onView(withId(R.id.view)).check(matches(withAttr(R.attr.colorError, BLUE)));</code>
   */
  @CheckResult public static AttributeMatcher withAttr(@AttrRes final int attr, @ColorInt final int color) {
    return new AttributeMatcher(attr, null, ColorChecker.from(color));
  }

  /**
   * Matches that the given attribute has the expected color.
   *
   * <p>Example usage:</p>
   * <code>onView(withId(R.id.view)).check(matches(withAttr(R.attr.colorError, "#0000ff")));</code>
   */
  @CheckResult public static AttributeMatcher withAttr(@AttrRes final int attr, final String color) {
    return withAttr(attr, Color.parseColor(color));
  }

  /**
   * Matches that the accent color has the expected color.
   *
   * <p>Example usage:</p>
   * <code>onView(withId(R.id.view)).check(matches(withColorAccentRes(R.color.green)));</code>
   */
  @CheckResult public static AttributeMatcher withColorAccentRes(@ColorRes final int colorRes) {
    return new AttributeMatcher(android.R.attr.colorAccent, "colorAccent", ColorChecker.fromRes(colorRes));
  }

  /**
   * Matches that the accent color has the expected color.
   *
   * <p>Example usage:</p>
   * <code>onView(withId(R.id.view)).check(matches(withColorAccent(GREEN)));</code>
   */
  @CheckResult public static AttributeMatcher withColorAccent(@ColorInt final int color) {
    return new AttributeMatcher(android.R.attr.colorAccent, "colorAccent", ColorChecker.from(color));
  }

  /**
   * Matches that the accent color has the expected color.
   *
   * <p>Example usage:</p>
   * <code>onView(withId(R.id.view)).check(matches(withColorAccent("#00ff00")));</code>
   */
  @CheckResult public static AttributeMatcher withColorAccent(final String color) {
    return withColorAccent(Color.parseColor(color));
  }

  /**
   * Matches that the button color has the expected color.
   *
   * <p>Example usage:</p>
   * <code>onView(withId(R.id.view)).check(matches(withColorButtonNormalRes(R.color.red)));</code>
   */
  @CheckResult public static AttributeMatcher withColorButtonNormalRes(@ColorRes final int colorRes) {
    return new AttributeMatcher(android.R.attr.colorButtonNormal, "colorButtonNormal", ColorChecker.fromRes(colorRes));
  }

  /**
   * Matches that the button color has the expected color.
   *
   * <p>Example usage:</p>
   * <code>onView(withId(R.id.view)).check(matches(withColorButtonNormal(RED)));</code>
   */
  @CheckResult public static AttributeMatcher withColorButtonNormal(@ColorInt final int color) {
    return new AttributeMatcher(android.R.attr.colorButtonNormal, "colorButtonNormal", ColorChecker.from(color));
  }

  /**
   * Matches that the button color has the expected color.
   *
   * <p>Example usage:</p>
   * <code>onView(withId(R.id.view)).check(matches(withColorButtonNormal("#ff0000")));</code>
   */
  @CheckResult public static AttributeMatcher withColorButtonNormal(final String color) {
    return withColorButtonNormal(Color.parseColor(color));
  }

  @AttrRes private final int attr;
  @Nullable private final String name;
  private final ColorChecker colorChecker;

  private AttributeMatcher(final int attr, @Nullable final String name, final ColorChecker colorChecker) {
    super(TextView.class);

    this.name = name;
    this.colorChecker = colorChecker;
    this.attr = attr;
  }

  @Override protected boolean matchesSafely(final TextView item) {
    final int color = resolveAttribute(item, attr);
    return colorChecker.matches(color, item.getContext());
  }

  @Override public void describeTo(final Description description) {
    description.appendText("with ")
        .appendText(name != null ? name : String.valueOf(attr))
        .appendText(": ");
  }
}
