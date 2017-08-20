package com.vanniktech.espresso.core.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.AttrRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.View;

import static android.view.View.VISIBLE;

final class Utils {
  static final int NO_DRAWABLE = -1;

  static int resolveAttribute(final View view, @AttrRes final int attr) {
    final TypedValue value = new TypedValue();
    view.getContext().getTheme().resolveAttribute(attr, value, true);
    return value.data;
  }

  @NonNull static <T> T checkNotNull(@Nullable final T reference, final String message) {
    if (reference == null) {
      throw new IllegalArgumentException(message);
    }

    return reference;
  }

  static boolean drawableMatches(final View view, final Drawable drawable, @DrawableRes final int expectedId) {
    final boolean isVisible = view.getVisibility() == VISIBLE;

    if (expectedId == NO_DRAWABLE) {
      return isVisible && drawable == null;
    }

    final Context context = view.getContext();
    return isVisible && checkNotNull(drawable.getConstantState(), "constantState == null").equals(ContextCompat.getDrawable(context, expectedId).getConstantState());
  }

  private Utils() {
    throw new AssertionError("No instances.");
  }
}
