Espresso Utils
==============

[![Build Status](https://travis-ci.org/vanniktech/espresso-utils.svg?branch=master)](https://travis-ci.org/vanniktech/espresso-utils?branch=master)
[![Codecov](https://codecov.io/github/vanniktech/espresso-utils/coverage.svg?branch=master)](https://codecov.io/github/vanniktech/espresso-utils?branch=master)
[![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Provides helper methods for asserting a few things that Espresso does not support out of the box.

# Espresso Core Utils

```groovy
compile 'com.vanniktech:espresso-core-utils:0.1.0'
```

Examples:

```java
withColorAccentRes(@ColorRes int colorRes)
withColorAccent(@ColorInt int color)
withColorAccent(String color)
withColorButtonNormalRes(@ColorRes int colorRes)
withColorButtonNormal(@ColorInt int color)
withColorButtonNormal(String color)
withHintTextColorRes(@ColorRes int colorRes)
withHintTextColor(@ColorInt int color)
withHintTextColor(String color)
withTextColorRes(@ColorRes int colorRes)
withTextColor(@ColorInt int color)
withTextColor(String color)
withAttrRes(@Attr int attr, @ColorRes int colorRes)
withAttr(@Attr int attr, @ColorInt int color)
withAttr(@Attr int attr, String color)
withDrawable(@DrawableRes int drawable)
withNoDrawable()
withProgress(int progress)
withCurrentItem(int currentItem)
```

# License

Copyright (C) 2017 Vanniktech - Niklas Baudy

Licensed under the Apache License, Version 2.0
