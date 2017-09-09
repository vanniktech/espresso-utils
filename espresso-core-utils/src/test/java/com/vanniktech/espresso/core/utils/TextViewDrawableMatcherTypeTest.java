package com.vanniktech.espresso.core.utils;

import com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.Type;
import org.junit.Test;

import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.Type.DRAWABLE_BOTTOM;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.Type.DRAWABLE_LEFT;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.Type.DRAWABLE_RELATIVE_BOTTOM;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.Type.DRAWABLE_RELATIVE_LEFT;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.Type.DRAWABLE_RELATIVE_RIGHT;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.Type.DRAWABLE_RELATIVE_TOP;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.Type.DRAWABLE_RIGHT;
import static com.vanniktech.espresso.core.utils.TextViewDrawableMatcher.Type.DRAWABLE_TOP;
import static org.assertj.core.api.Java6Assertions.assertThat;

public final class TextViewDrawableMatcherTypeTest {
  @Test public void entries() {
    assertThat(Type.values()).containsExactly(
        DRAWABLE_LEFT,
        DRAWABLE_RELATIVE_LEFT,
        DRAWABLE_TOP,
        DRAWABLE_RELATIVE_TOP,
        DRAWABLE_RIGHT,
        DRAWABLE_RELATIVE_RIGHT,
        DRAWABLE_BOTTOM,
        DRAWABLE_RELATIVE_BOTTOM
    );
  }
}
