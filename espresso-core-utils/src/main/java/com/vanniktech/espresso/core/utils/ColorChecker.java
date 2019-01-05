package com.vanniktech.espresso.core.utils;

import android.content.Context;
import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import static com.vanniktech.espresso.core.utils.Utils.checkNotNull;

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
    }

    return color == ContextCompat.getColor(context, checkNotNull(colorRes, "colorRes == null"));
  }
}
