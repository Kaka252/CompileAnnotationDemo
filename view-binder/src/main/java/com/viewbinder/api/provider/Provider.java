package com.viewbinder.api.provider;

import android.content.Context;
import android.view.View;

/**
 * 作者：ZhouYou
 * 日期：2017/2/11.
 */
public interface Provider {

    Context getContext(Object source);

    View findView(Object source, int id);
}
