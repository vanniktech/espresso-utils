package com.vanniktech.espresso.core.utils;

import android.graphics.Color;
import android.support.annotation.AttrRes;
import android.support.annotation.CheckResult;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.widget.TextView;
import org.hamcrest.Description;

import static com.vanniktech.espresso.core.utils.Utils.resolveAttribute;

public final class AttributeMatcher extends BoundedMatcher<View, TextView> {
  @CheckResult public static AttributeMatcher withAttrRes(@AttrRes final int attr, @ColorRes final int colorRes) {
    return new AttributeMatcher(attr, null, ColorChecker.fromRes(colorRes));
  }

  @CheckResult public static AttributeMatcher withAttr(@AttrRes final int attr, @ColorInt final int color) {
    return new AttributeMatcher(attr, null, ColorChecker.from(color));
  }

  @CheckResult public static AttributeMatcher withAttr(@AttrRes final int attr, final String color) {
    return withAttr(attr, Color.parseColor(color));
  }

  @CheckResult public static AttributeMatcher withColorAccentRes(@ColorRes final int colorRes) {
    return new AttributeMatcher(R.attr.colorAccent, "colorAccent", ColorChecker.fromRes(colorRes));
  }

  @CheckResult public static AttributeMatcher withColorAccent(@ColorInt final int color) {
    return new AttributeMatcher(R.attr.colorAccent, "colorAccent", ColorChecker.from(color));
  }

  @CheckResult public static AttributeMatcher withColorAccent(final String color) {
    return withColorAccent(Color.parseColor(color));
  }

  @CheckResult public static AttributeMatcher withColorButtonNormalRes(@ColorRes final int colorRes) {
    return new AttributeMatcher(R.attr.colorButtonNormal, "colorButtonNormal", ColorChecker.fromRes(colorRes));
  }

  @CheckResult public static AttributeMatcher withColorButtonNormal(@ColorInt final int color) {
    return new AttributeMatcher(R.attr.colorButtonNormal, "colorButtonNormal", ColorChecker.from(color));
  }

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
    description.appendText("with ").appendText(name != null ? name : String.valueOf(attr)).appendText(" : ");
  }
}
