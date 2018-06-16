package com.vanniktech.espresso.core.utils;

import android.support.annotation.CheckResult;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;
import android.widget.ProgressBar;
import org.hamcrest.Matcher;

import static android.support.test.espresso.action.ViewActions.actionWithAssertions;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.core.AllOf.allOf;

public final class SetProgressAction implements ViewAction {
  /**
   * Sets the given progress on a ProgressBar.
   *
   * <p>Example usage:</p>
   * <code>onView(withId(R.id.view)).perform(setProgress(95));</code>
   */
  @CheckResult public static ViewAction setProgress(final int progress) {
    return actionWithAssertions(new SetProgressAction(progress));
  }

  private final int progress;

  private SetProgressAction(final int progress) {
    this.progress = progress;
  }

  @Override public Matcher<View> getConstraints() {
    return allOf(isDisplayed(), isAssignableFrom(ProgressBar.class));
  }

  @Override public void perform(final UiController uiController, final View view) {
    ((ProgressBar) view).setProgress(progress);
  }

  @Override public String getDescription() {
    return "set progress: " + progress;
  }
}
