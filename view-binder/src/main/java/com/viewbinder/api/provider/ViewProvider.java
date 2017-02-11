package com.viewbinder.api.provider;

import android.content.Context;
import android.view.View;

/**
 * 作者：ZhouYou
 * 日期：2017/2/11.
 */
public class ViewProvider implements Provider {
    @Override
    public Context getContext(Object source) {
        return ((View) source).getContext();
    }

    @Override
    public View findView(Object source, int id) {
        return ((View) source).findViewById(id);
    }
}
