package com.vanniktech.espresso.core.utils;

import android.support.annotation.CheckResult;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;
import android.widget.TextView;
import org.hamcrest.Matcher;

import static android.support.test.espresso.action.ViewActions.actionWithAssertions;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.core.AllOf.allOf;

public final class AppendTextAction implements ViewAction {
  @CheckResult static ViewAction appendText(final String text) {
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
