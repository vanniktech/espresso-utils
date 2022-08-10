package com.vanniktech.espresso.core.utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.vanniktech.espresso.core.utils.Utils.checkNotNull;
import static org.junit.Assert.assertEquals;

public final class UtilsTest {
  @Rule public final ExpectedException expectedException = ExpectedException.none();


  @Test public void checkNotNullNoNull() {
    assertEquals(Integer.valueOf(5), checkNotNull(5, "should never be"));
    assertEquals("5", checkNotNull("5", "should never be"));
    assertEquals(Float.valueOf(3f), checkNotNull(3f, "should never be"));
  }

  @Test public void checkNotNullNull() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("null == null");
    checkNotNull(null, "null == null");
  }
}
