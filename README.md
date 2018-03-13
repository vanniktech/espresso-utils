Espresso Utils
==============

[![Build Status](https://travis-ci.org/vanniktech/espresso-utils.svg?branch=master)](https://travis-ci.org/vanniktech/espresso-utils?branch=master)
[![Codecov](https://codecov.io/github/vanniktech/espresso-utils/coverage.svg?branch=master)](https://codecov.io/github/vanniktech/espresso-utils?branch=master)
[![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Provides helper methods for asserting a few things that Espresso does not support out of the box.

# Espresso Core Utils

```groovy
androidTestImplementation 'com.vanniktech:espresso-core-utils:0.2.0'
```

### Snapshots

```groovy
repositories {
  maven { url "https://oss.sonatype.org/content/repositories/snapshots" }
}

dependencies {
  androidTestImplementation 'com.vanniktech:espresso-core-utils:0.3.0-SNAPSHOT'
}
```

# APIs

### ViewActions:

All of those are ViewActions that can be placed inside the `perform` function. `onView(withId(R.id.view)).perform(...);`

```java
appendText(String text)
```

### ViewMatchers:

All of those are ViewMatchers that can be placed inside the `matches` function. `onView(withId(R.id.view)).check(matches(...));`

```java
withAttrRes(@AttrRes int attr, @ColorRes int colorRes)
withAttr(@AttrRes int attr, @ColorInt int color)
withAttr(@AttrRes int attr, String color)
withColorAccentRes(@ColorRes int colorRes)
withColorAccent(@ColorInt int color)
withColorAccent(String color)
withColorButtonNormalRes(@ColorRes int colorRes)
withColorButtonNormal(@ColorInt int color)
withColorButtonNormal(String color)
withCurrentItem(int currentItem)
withDrawable(@DrawableRes int resourceId)
withNoDrawable()
withHintTextColorRes(@ColorRes int colorRes)
withHintTextColor(@ColorInt int color)
withHintTextColor(String color)
withProgress(int progress)
withTextColorRes(@ColorRes int colorRes)
withTextColor(@ColorInt int color)
withTextColor(String color)
withTextViewDrawableLeft(@DrawableRes int resourceId)
withNoTextViewDrawableLeft()
withTextViewDrawableRelativeLeft(@DrawableRes int resourceId)
withNoTextViewDrawableRelativeLeft()
withTextViewDrawableTop(@DrawableRes int resourceId)
withNoTextViewDrawableTop()
withTextViewDrawableRelativeTop(@DrawableRes int resourceId)
withNoTextViewDrawableRelativeTop()
withTextViewDrawableRight(@DrawableRes int resourceId)
withNoTextViewDrawableRight()
withTextViewDrawableRelativeRight(@DrawableRes int resourceId)
withNoTextViewDrawableRelativeRight()
withTextViewDrawableBottom(@DrawableRes int resourceId)
withNoTextViewDrawableBottom()
withTextViewDrawableRelativeBottom(@DrawableRes int resourceId)
withNoTextViewDrawableRelativeBottom()
```

There's more documentation available in the Javadoc. Also have a look at the [tests](espresso-core-utils/src/androidTest/java/com/vanniktech/espresso/core/utils) for further usages.

# License

Copyright (C) 2017 Vanniktech - Niklas Baudy

Licensed under the Apache License, Version 2.0
