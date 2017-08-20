package com.vanniktech.espresso.core.utils;

import android.graphics.drawable.Drawable;
import android.support.annotation.CheckResult;
import android.support.annotation.DrawableRes;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.widget.ImageView;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import static com.vanniktech.espresso.core.utils.Utils.NO_DRAWABLE;
import static com.vanniktech.espresso.core.utils.Utils.drawableMatches;

public final class DrawableMatcher extends BoundedMatcher<View, ImageView> {
  @CheckResult public static Matcher<View> withDrawable(@DrawableRes final int resourceId) {
    return new DrawableMatcher(resourceId);
  }

  @CheckResult public static Matcher<View> withNoDrawable() {
    return new DrawableMatcher(NO_DRAWABLE);
  }

  private final int expectedId;

  private DrawableMatcher(final int expectedId) {
    super(ImageView.class);

    this.expectedId = expectedId;
  }

  @Override protected boolean matchesSafely(final ImageView imageView) {
    final Drawable drawable = imageView.getDrawable();
    return drawableMatches(imageView, drawable, expectedId);
  }

  @Override public void describeTo(final Description description) {
    if (expectedId == NO_DRAWABLE) {
      description.appendText("with no drawable");
    } else {
      description.appendText("with drawable from resource id: ").appendValue(expectedId);
    }
  }
}
