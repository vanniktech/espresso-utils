package com.vanniktech.espresso.core.utils;

import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.widget.ImageView;
import org.hamcrest.Description;

import static com.vanniktech.espresso.core.utils.Utils.NO_DRAWABLE;
import static com.vanniktech.espresso.core.utils.Utils.drawableMatches;

public final class DrawableMatcher extends BoundedMatcher<View, ImageView> {
  /**
   * Matches that the given view has the expected drawable.
   *
   * <p>Example usage:</p>
   * <code>onView(withId(R.id.view)).check(matches(withDrawable(R.drawable.android)));</code>
   */
  @CheckResult public static DrawableMatcher withDrawable(@DrawableRes final int resourceId) {
    return new DrawableMatcher(resourceId);
  }

  /**
   * Matches that the given view has no drawable.
   *
   * <p>Example usage:</p>
   * <code>onView(withId(R.id.view)).check(matches(withNoDrawable()));</code>
   */
  @CheckResult public static DrawableMatcher withNoDrawable() {
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
