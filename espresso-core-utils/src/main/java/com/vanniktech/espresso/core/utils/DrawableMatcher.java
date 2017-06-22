package com.vanniktech.espresso.core.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.CheckResult;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.view.View.VISIBLE;

public final class DrawableMatcher extends TypeSafeMatcher<View> {
  static final int NO_DRAWABLE = -1;

  @CheckResult public static Matcher<View> withDrawable(@DrawableRes final int resourceId) {
    return new DrawableMatcher(resourceId);
  }

  @CheckResult public static Matcher<View> withNoDrawable() {
    return new DrawableMatcher(NO_DRAWABLE);
  }

  private final int expectedId;
  private String resourceName;

  private DrawableMatcher(final int expectedId) {
    super(View.class);

    this.expectedId = expectedId;
  }

  @Override protected boolean matchesSafely(final View target) {
    if (!(target instanceof ImageView)) {
      return false;
    }

    final ImageView imageView = (ImageView) target;
    final boolean isVisible = imageView.getVisibility() == VISIBLE;

    if (expectedId == NO_DRAWABLE) {
      return isVisible && imageView.getDrawable() == null;
    }

    final Context context = target.getContext();
    final Resources resources = context.getResources();
    final Drawable expectedDrawable = ContextCompat.getDrawable(context, expectedId);
    resourceName = resources.getResourceEntryName(expectedId);

    if (expectedDrawable == null) {
      return false;
    }

    final Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
    final Bitmap otherBitmap = ((BitmapDrawable) expectedDrawable).getBitmap();
    return isVisible && bitmap.sameAs(otherBitmap);
  }

  @Override public void describeTo(final Description description) {
    description.appendText("with drawable from resource id: ").appendValue(expectedId);

    if (resourceName != null) {
      description.appendText("[").appendText(resourceName).appendText("]");
    }
  }
}
