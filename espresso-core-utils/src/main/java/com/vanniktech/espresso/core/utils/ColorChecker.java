package com.vanniktech.espresso.core.utils;

import android.content.Context;
import android.support.annotation.CheckResult;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

final class ColorChecker {
  @CheckResult static ColorChecker fromRes(@ColorRes final int colorRes) {
    final ColorChecker matcher = new ColorChecker();
    matcher.colorRes = colorRes;
    return matcher;
  }

  @CheckResult static ColorChecker from(@ColorInt final int color) {
    final ColorChecker matcher = new ColorChecker();
    matcher.colorInt = color;
    return matcher;
  }

  @Nullable @ColorRes private Integer colorRes;
  @Nullable @ColorInt private Integer colorInt;

  private ColorChecker() {
  }

  boolean matches(final int color, final Context context) {
    if (colorInt != null) {
      return color == colorInt;
    } else if (colorRes != null) {
      return color == ContextCompat.getColor(context, colorRes);
    }

    throw new AssertionError();
  }
}
