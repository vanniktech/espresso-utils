package com.vanniktech.espresso.core.utils;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CheckResult;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import org.hamcrest.Matcher;

import static androidx.test.espresso.action.ViewActions.actionWithAssertions;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.allOf;

public final class AppendTextAction implements ViewAction {
  /**
   * Appends the given text to a TextView.
   *
   * <p>Example usage:</p>
   * <code>onView(withId(R.id.view)).perform(appendText("Something"));</code>
   */
  @CheckResult public static ViewAction appendText(final String text) {
    return actionWithAssertions(new AppendTextAction(text));
  }

  private final String text;

  private AppendTextAction(final String text) {
    this.text = text;
  }

  @Override public Matcher<View> getConstraints() {
    return allOf(isDisplayed(), isAssignableFrom(TextView.class));
  }

  @Override public void perform(final UiController uiController, final View view) {
    ((TextView) view).append(text);
  }

  @Override public String getDescription() {
    return "append text: " + text;
  }
}
