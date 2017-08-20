package com.vanniktech.espresso.core.utils;

import android.annotation.TargetApi;
import android.support.annotation.DrawableRes;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.vanniktech.espresso.core.utils.test.R;
import junit.framework.AssertionFailedError;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.vanniktech.espresso.core.utils.DrawableMatcherActivity.VIEW_ID;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.withNoTextViewDrawableBottom;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.withNoTextViewDrawableLeft;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.withNoTextViewDrawableRelativeBottom;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.withNoTextViewDrawableRelativeLeft;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.withNoTextViewDrawableRelativeRight;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.withNoTextViewDrawableRelativeTop;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.withNoTextViewDrawableRight;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.withNoTextViewDrawableTop;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.withTextViewDrawableBottom;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.withTextViewDrawableLeft;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.withTextViewDrawableRelativeBottom;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.withTextViewDrawableRelativeLeft;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.withTextViewDrawableRelativeRight;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.withTextViewDrawableRelativeTop;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.withTextViewDrawableRight;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.withTextViewDrawableTop;

@RunWith(AndroidJUnit4.class) @TargetApi(JELLY_BEAN_MR1) @SuppressWarnings("PMD.GodClass") public final class TextViewDrawableMatcherTest {
  @Rule public final ExpectedException expectedException = ExpectedException.none();

  @Rule public final ActivityTestRule<TextViewDrawableMatcherActivity> activityTestRule = new ActivityTestRule<>(TextViewDrawableMatcherActivity.class);

  @Test public void withTextViewDrawableLeftMatches() throws Throwable {
    setDrawableLeft(R.drawable.android);

    onView(withId(VIEW_ID)).check(matches(withTextViewDrawableLeft(R.drawable.android)));
  }

  @Test public void withTextViewDrawableLeftDoesNotMatch() throws Throwable {
    setDrawableLeft(R.drawable.android);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with left drawable from resource id: <" + R.drawable.northern_lights + ">' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withTextViewDrawableLeft(R.drawable.northern_lights)));
  }

  @Test public void withNoTextViewDrawableLeftMatches() {
    onView(withId(VIEW_ID)).check(matches(withNoTextViewDrawableLeft()));
  }

  @Test public void withNoTextViewDrawableLeftDoesNotMatch() throws Throwable {
    setDrawableLeft(R.drawable.android);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with no left drawable' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withNoTextViewDrawableLeft()));
  }

  @Test public void withTextViewDrawableRelativeLeftMatches() throws Throwable {
    setDrawableRelativeLeft(R.drawable.android);

    onView(withId(VIEW_ID)).check(matches(withTextViewDrawableRelativeLeft(R.drawable.android)));
  }

  @Test public void withTextViewDrawableRelativeLeftDoesNotMatch() throws Throwable {
    setDrawableRelativeLeft(R.drawable.android);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with relative left drawable from resource id: <" + R.drawable.northern_lights + ">' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withTextViewDrawableRelativeLeft(R.drawable.northern_lights)));
  }

  @Test public void withNoTextViewDrawableRelativeLeftMatches() {
    onView(withId(VIEW_ID)).check(matches(withNoTextViewDrawableRelativeLeft()));
  }

  @Test public void withNoTextViewDrawableRelativeLeftDoesNotMatch() throws Throwable {
    setDrawableRelativeLeft(R.drawable.android);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with no relative left drawable' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withNoTextViewDrawableRelativeLeft()));
  }

  @Test public void withTextViewDrawableTopMatches() throws Throwable {
    setDrawableTop(R.drawable.android);

    onView(withId(VIEW_ID)).check(matches(withTextViewDrawableTop(R.drawable.android)));
  }

  @Test public void withTextViewDrawableTopDoesNotMatch() throws Throwable {
    setDrawableTop(R.drawable.android);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with top drawable from resource id: <" + R.drawable.northern_lights + ">' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withTextViewDrawableTop(R.drawable.northern_lights)));
  }

  @Test public void withNoTextViewDrawableTopMatches() {
    onView(withId(VIEW_ID)).check(matches(withNoTextViewDrawableTop()));
  }

  @Test public void withNoTextViewDrawableTopDoesNotMatch() throws Throwable {
    setDrawableTop(R.drawable.android);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with no top drawable' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withNoTextViewDrawableTop()));
  }

  @Test public void withTextViewDrawableRelativeTopMatches() throws Throwable {
    setDrawableRelativeTop(R.drawable.android);

    onView(withId(VIEW_ID)).check(matches(withTextViewDrawableRelativeTop(R.drawable.android)));
  }

  @Test public void withTextViewDrawableRelativeTopDoesNotMatch() throws Throwable {
    setDrawableRelativeTop(R.drawable.android);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with relative top drawable from resource id: <" + R.drawable.northern_lights + ">' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withTextViewDrawableRelativeTop(R.drawable.northern_lights)));
  }

  @Test public void withNoTextViewDrawableRelativeTopMatches() {
    onView(withId(VIEW_ID)).check(matches(withNoTextViewDrawableRelativeTop()));
  }

  @Test public void withNoTextViewDrawableRelativeTopDoesNotMatch() throws Throwable {
    setDrawableRelativeTop(R.drawable.android);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with no relative top drawable' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withNoTextViewDrawableRelativeTop()));
  }

  @Test public void withTextViewDrawableRightMatches() throws Throwable {
    setDrawableRight(R.drawable.android);

    onView(withId(VIEW_ID)).check(matches(withTextViewDrawableRight(R.drawable.android)));
  }

  @Test public void withTextViewDrawableRightDoesNotMatch() throws Throwable {
    setDrawableRight(R.drawable.android);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with right drawable from resource id: <" + R.drawable.northern_lights + ">' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withTextViewDrawableRight(R.drawable.northern_lights)));
  }

  @Test public void withNoTextViewDrawableRightMatches() {
    onView(withId(VIEW_ID)).check(matches(withNoTextViewDrawableRight()));
  }

  @Test public void withNoTextViewDrawableRightDoesNotMatch() throws Throwable {
    setDrawableRight(R.drawable.android);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with no right drawable' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withNoTextViewDrawableRight()));
  }

  @Test public void withTextViewDrawableRelativeRightMatches() throws Throwable {
    setDrawableRelativeRight(R.drawable.android);

    onView(withId(VIEW_ID)).check(matches(withTextViewDrawableRelativeRight(R.drawable.android)));
  }

  @Test public void withTextViewDrawableRelativeRightDoesNotMatch() throws Throwable {
    setDrawableRelativeRight(R.drawable.android);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with relative right drawable from resource id: <" + R.drawable.northern_lights + ">' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withTextViewDrawableRelativeRight(R.drawable.northern_lights)));
  }

  @Test public void withNoTextViewDrawableRelativeRightMatches() {
    onView(withId(VIEW_ID)).check(matches(withNoTextViewDrawableRelativeRight()));
  }

  @Test public void withNoTextViewDrawableRelativeRightDoesNotMatch() throws Throwable {
    setDrawableRelativeRight(R.drawable.android);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with no relative right drawable' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withNoTextViewDrawableRelativeRight()));
  }

  @Test public void withTextViewDrawableBottomMatches() throws Throwable {
    setDrawableBottom(R.drawable.android);

    onView(withId(VIEW_ID)).check(matches(withTextViewDrawableBottom(R.drawable.android)));
  }

  @Test public void withTextViewDrawableBottomDoesNotMatch() throws Throwable {
    setDrawableBottom(R.drawable.android);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with bottom drawable from resource id: <" + R.drawable.northern_lights + ">' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withTextViewDrawableBottom(R.drawable.northern_lights)));
  }

  @Test public void withNoTextViewDrawableBottomMatches() {
    onView(withId(VIEW_ID)).check(matches(withNoTextViewDrawableBottom()));
  }

  @Test public void withNoTextViewDrawableBottomDoesNotMatch() throws Throwable {
    setDrawableBottom(R.drawable.android);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with no bottom drawable' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withNoTextViewDrawableBottom()));
  }

  @Test public void withTextViewDrawableRelativeBottomMatches() throws Throwable {
    setDrawableRelativeBottom(R.drawable.android);

    onView(withId(VIEW_ID)).check(matches(withTextViewDrawableRelativeBottom(R.drawable.android)));
  }

  @Test public void withTextViewDrawableRelativeBottomDoesNotMatch() throws Throwable {
    setDrawableRelativeBottom(R.drawable.android);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with relative bottom drawable from resource id: <" + R.drawable.northern_lights + ">' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withTextViewDrawableRelativeBottom(R.drawable.northern_lights)));
  }

  @Test public void withNoTextViewDrawableRelativeBottomMatches() {
    onView(withId(VIEW_ID)).check(matches(withNoTextViewDrawableRelativeBottom()));
  }

  @Test public void withNoTextViewDrawableRelativeBottomDoesNotMatch() throws Throwable {
    setDrawableRelativeBottom(R.drawable.android);

    expectedException.expect(AssertionFailedError.class);
    expectedException.expectMessage("'with no relative bottom drawable' doesn't match the selected view.");
    onView(withId(VIEW_ID)).check(matches(withNoTextViewDrawableRelativeBottom()));
  }

  private void setDrawableLeft(@DrawableRes final int drawable) throws Throwable {
    activityTestRule.runOnUiThread(new Runnable() {
      @Override public void run() {
        activityTestRule.getActivity().textView.setCompoundDrawablesWithIntrinsicBounds(drawable, 0, 0, 0);
      }
    });
  }

  private void setDrawableRelativeLeft(@DrawableRes final int drawable) throws Throwable {
    activityTestRule.runOnUiThread(new Runnable() {
      @Override public void run() {
        activityTestRule.getActivity().textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, 0, 0, 0);
      }
    });
  }

  private void setDrawableTop(@DrawableRes final int drawable) throws Throwable {
    activityTestRule.runOnUiThread(new Runnable() {
      @Override public void run() {
        activityTestRule.getActivity().textView.setCompoundDrawablesWithIntrinsicBounds(0, drawable, 0, 0);
      }
    });
  }

  private void setDrawableRelativeTop(@DrawableRes final int drawable) throws Throwable {
    activityTestRule.runOnUiThread(new Runnable() {
      @Override public void run() {
        activityTestRule.getActivity().textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, drawable, 0, 0);
      }
    });
  }

  private void setDrawableRight(@DrawableRes final int drawable) throws Throwable {
    activityTestRule.runOnUiThread(new Runnable() {
      @Override public void run() {
        activityTestRule.getActivity().textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0);
      }
    });
  }

  private void setDrawableRelativeRight(@DrawableRes final int drawable) throws Throwable {
    activityTestRule.runOnUiThread(new Runnable() {
      @Override public void run() {
        activityTestRule.getActivity().textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, drawable, 0);
      }
    });
  }

  private void setDrawableBottom(@DrawableRes final int drawable) throws Throwable {
    activityTestRule.runOnUiThread(new Runnable() {
      @Override public void run() {
        activityTestRule.getActivity().textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, drawable);
      }
    });
  }

  private void setDrawableRelativeBottom(@DrawableRes final int drawable) throws Throwable {
    activityTestRule.runOnUiThread(new Runnable() {
      @Override public void run() {
        activityTestRule.getActivity().textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, drawable);
      }
    });
  }
}
