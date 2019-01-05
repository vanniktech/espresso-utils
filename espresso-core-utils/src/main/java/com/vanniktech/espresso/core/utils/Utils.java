package com.vanniktech.espresso.core.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import static android.view.View.VISIBLE;

final class Utils {
  static final int NO_DRAWABLE = -1;
  static final int INDEX_LEFT = 0;
  static final int INDEX_TOP = 1;
  static final int INDEX_RIGHT = 2;
  static final int INDEX_BOTTOM = 3;

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
