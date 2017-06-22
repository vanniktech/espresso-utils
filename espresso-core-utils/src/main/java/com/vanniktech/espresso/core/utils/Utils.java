package com.vanniktech.espresso.core.utils;

import android.support.annotation.AttrRes;
import android.util.TypedValue;
import android.view.View;

final class Utils {
  static int resolveAttribute(final View view, @AttrRes final int attr) {
    final TypedValue value = new TypedValue();
    view.getContext().getTheme().resolveAttribute(attr, value, true);
    return value.data;
  }

  private Utils() {
    throw new AssertionError("No instances.");
  }
}
