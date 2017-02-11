package com.viewbinder.api.provider;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/**
 * 作者：ZhouYou
 * 日期：2017/2/11.
 */
public class ActivityProvider implements Provider {
    @Override
    public Context getContext(Object source) {
        return ((Activity) source);
    }

    @Override
    public View findView(Object source, int id) {
        return ((Activity) source).findViewById(id);
    }
}
