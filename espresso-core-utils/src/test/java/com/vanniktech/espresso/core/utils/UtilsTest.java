package com.vanniktech.espresso.core.utils;

import com.pushtorefresh.private_constructor_checker.PrivateConstructorChecker;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.vanniktech.espresso.core.utils.Utils.checkNotNull;
import static org.assertj.core.api.Java6Assertions.assertThat;

public final class UtilsTest {
  @Rule public final ExpectedException expectedException = ExpectedException.none();

  @Test public void constructorShouldBePrivate() {
    PrivateConstructorChecker.forClass(Utils.class)
        .expectedTypeOfException(AssertionError.class)
        .expectedExceptionMessage("No instances.")
        .check();
  }

  @Test public void checkNotNullNoNull() {
    assertThat(checkNotNull(5, "should never be")).isEqualTo(5);
    assertThat(checkNotNull("5", "should never be")).isEqualTo("5");
    assertThat(checkNotNull(3f, "should never be")).isEqualTo(3f);
  }

  @Test public void checkNotNullNull() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("null == null");
    checkNotNull(null, "null == null");
  }
}
