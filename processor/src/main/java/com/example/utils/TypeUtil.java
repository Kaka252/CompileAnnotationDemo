package com.example.utils;

import com.squareup.javapoet.ClassName;

/**
 * ZhouYou
 * 2017/2/11.
 */
public class TypeUtil {

    public static final ClassName ANDROID_VIEW = ClassName.get("android.view", "View");
    public static final ClassName ANDROID_ON_CLICK_LISTENER = ClassName.get("android.view", "View", "OnClickListener");
    public static final ClassName FINDER = ClassName.get("com.viewbinder.api", "Finder");
    public static final ClassName PROVIDER = ClassName.get("com.viewbinder.api.provider", "Provider");
}
