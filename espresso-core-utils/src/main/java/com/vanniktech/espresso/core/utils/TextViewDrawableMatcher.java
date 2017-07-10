package com.vanniktech.espresso.core.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.support.annotation.CheckResult;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.TextView;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static com.vanniktech.espresso.core.utils.Utils.NO_DRAWABLE;
import static com.vanniktech.espresso.core.utils.Utils.drawableMatches;

public final class TextViewDrawableMatcher extends TypeSafeMatcher<View> {
  private static final int DRAWABLE_LEFT = 0;
  private static final int DRAWABLE_RELATIVE_LEFT = 4;
  private static final int DRAWABLE_TOP = 1;
  private static final int DRAWABLE_RELATIVE_TOP = 5;
  private static final int DRAWABLE_RIGHT = 2;
  private static final int DRAWABLE_RELATIVE_RIGHT = 6;
  private static final int DRAWABLE_BOTTOM = 3;
  private static final int DRAWABLE_RELATIVE_BOTTOM = 7;

  @CheckResult public static Matcher<View> withTextViewDrawableLeft(@DrawableRes final int resourceId) {
    return new TextViewDrawableMatcher(resourceId, DRAWABLE_LEFT);
  }

  @CheckResult public static Matcher<View> withNoTextViewDrawableLeft() {
    return new TextViewDrawableMatcher(NO_DRAWABLE, DRAWABLE_LEFT);
  }

  @CheckResult @TargetApi(JELLY_BEAN_MR1) public static Matcher<View> withTextViewDrawableRelativeLeft(@DrawableRes final int resourceId) {
    return new TextViewDrawableMatcher(resourceId, DRAWABLE_RELATIVE_LEFT);
  }

  @CheckResult @TargetApi(JELLY_BEAN_MR1) public static Matcher<View> withNoTextViewDrawableRelativeLeft() {
    return new TextViewDrawableMatcher(NO_DRAWABLE, DRAWABLE_RELATIVE_LEFT);
  }

  @CheckResult public static Matcher<View> withTextViewDrawableTop(@DrawableRes final int resourceId) {
    return new TextViewDrawableMatcher(resourceId, DRAWABLE_TOP);
  }

  @CheckResult public static Matcher<View> withNoTextViewDrawableTop() {
    return new TextViewDrawableMatcher(NO_DRAWABLE, DRAWABLE_TOP);
  }

  @CheckResult @TargetApi(JELLY_BEAN_MR1) public static Matcher<View> withTextViewDrawableRelativeTop(@DrawableRes final int resourceId) {
    return new TextViewDrawableMatcher(resourceId, DRAWABLE_RELATIVE_TOP);
  }

  @CheckResult @TargetApi(JELLY_BEAN_MR1) public static Matcher<View> withNoTextViewDrawableRelativeTop() {
    return new TextViewDrawableMatcher(NO_DRAWABLE, DRAWABLE_RELATIVE_TOP);
  }

  @CheckResult public static Matcher<View> withTextViewDrawableRight(@DrawableRes final int resourceId) {
    return new TextViewDrawableMatcher(resourceId, DRAWABLE_RIGHT);
  }

  @CheckResult public static Matcher<View> withNoTextViewDrawableRight() {
    return new TextViewDrawableMatcher(NO_DRAWABLE, DRAWABLE_RIGHT);
  }

  @CheckResult @TargetApi(JELLY_BEAN_MR1) public static Matcher<View> withTextViewDrawableRelativeRight(@DrawableRes final int resourceId) {
    return new TextViewDrawableMatcher(resourceId, DRAWABLE_RELATIVE_RIGHT);
  }

  @CheckResult @TargetApi(JELLY_BEAN_MR1) public static Matcher<View> withNoTextViewDrawableRelativeRight() {
    return new TextViewDrawableMatcher(NO_DRAWABLE, DRAWABLE_RELATIVE_RIGHT);
  }

  @CheckResult public static Matcher<View> withTextViewDrawableBottom(@DrawableRes final int resourceId) {
    return new TextViewDrawableMatcher(resourceId, DRAWABLE_BOTTOM);
  }

  @CheckResult public static Matcher<View> withNoTextViewDrawableBottom() {
    return new TextViewDrawableMatcher(NO_DRAWABLE, DRAWABLE_BOTTOM);
  }

  @CheckResult @TargetApi(JELLY_BEAN_MR1) public static Matcher<View> withTextViewDrawableRelativeBottom(@DrawableRes final int resourceId) {
    return new TextViewDrawableMatcher(resourceId, DRAWABLE_RELATIVE_BOTTOM);
  }

  @CheckResult @TargetApi(JELLY_BEAN_MR1) public static Matcher<View> withNoTextViewDrawableRelativeBottom() {
    return new TextViewDrawableMatcher(NO_DRAWABLE, DRAWABLE_RELATIVE_BOTTOM);
  }

  private final int expectedId;
  private final int identifier;

  private TextViewDrawableMatcher(final int expectedId, final int identifier) {
    super(View.class);

    this.expectedId = expectedId;
    this.identifier = identifier;
  }

  @Override protected boolean matchesSafely(final View target) {
    if (!(target instanceof TextView)) {
      return false;
    }

    final TextView textView = (TextView) target;
    final Drawable drawable = getDrawable(textView);
    return drawableMatches(textView, drawable, expectedId);
  }

  @SuppressLint("NewApi") private Drawable getDrawable(final TextView imageView) {
    switch (identifier) {
      case DRAWABLE_LEFT:
        return imageView.getCompoundDrawables()[DRAWABLE_LEFT];
      case DRAWABLE_RELATIVE_LEFT:
        return imageView.getCompoundDrawablesRelative()[DRAWABLE_LEFT];
      case DRAWABLE_TOP:
        return imageView.getCompoundDrawables()[DRAWABLE_TOP];
      case DRAWABLE_RELATIVE_TOP:
        return imageView.getCompoundDrawablesRelative()[DRAWABLE_TOP];
      case DRAWABLE_RIGHT:
        return imageView.getCompoundDrawables()[DRAWABLE_RIGHT];
      case DRAWABLE_RELATIVE_RIGHT:
        return imageView.getCompoundDrawablesRelative()[DRAWABLE_RIGHT];
      case DRAWABLE_BOTTOM:
        return imageView.getCompoundDrawables()[DRAWABLE_BOTTOM];
      case DRAWABLE_RELATIVE_BOTTOM:
        return imageView.getCompoundDrawablesRelative()[DRAWABLE_BOTTOM];
      default:
        throw new AssertionError();
    }
  }

  private String identifierAsString() {
    switch (identifier) {
      case DRAWABLE_LEFT:
        return "left";
      case DRAWABLE_RELATIVE_LEFT:
        return "relative left";
      case DRAWABLE_TOP:
        return "top";
      case DRAWABLE_RELATIVE_TOP:
        return "relative top";
      case DRAWABLE_RIGHT:
        return "right";
      case DRAWABLE_RELATIVE_RIGHT:
        return "relative right";
      case DRAWABLE_BOTTOM:
        return "bottom";
      case DRAWABLE_RELATIVE_BOTTOM:
        return "relative bottom";
      default:
        throw new AssertionError();
    }
  }

  @Override public void describeTo(final Description description) {
    description.appendText("with drawable ")
        .appendText(identifierAsString())
        .appendText(" from resource id: ")
        .appendValue(expectedId);
  }
}
