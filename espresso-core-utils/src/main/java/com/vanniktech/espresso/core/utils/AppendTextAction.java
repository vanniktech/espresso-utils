package com.vanniktech.espresso.core.utils;

import android.support.annotation.CheckResult;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;
import android.widget.EditText;
import org.hamcrest.Matcher;

import static android.support.test.espresso.action.ViewActions.actionWithAssertions;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.core.AllOf.allOf;

final class AppendTextAction implements ViewAction {
  @CheckResult static ViewAction appendText(final String text) {
    return actionWithAssertions(new AppendTextAction(text));
  }

  private final String text;

  private AppendTextAction(final String text) {
    this.text = text;
  }

  @SuppressWarnings("unchecked") @Override public Matcher<View> getConstraints() {
    return allOf(isDisplayed(), isAssignableFrom(EditText.class));
  }

  @Override public void perform(final UiController uiController, final View view) {
    ((EditText) view).append(text);
  }

  @Override public String getDescription() {
    return "append text";
  }
}
