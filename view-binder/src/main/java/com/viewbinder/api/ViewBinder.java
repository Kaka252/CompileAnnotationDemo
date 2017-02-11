package com.viewbinder.api;

import android.app.Activity;
import android.view.View;

import com.viewbinder.api.provider.ActivityProvider;
import com.viewbinder.api.provider.Provider;
import com.viewbinder.api.provider.ViewProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhouyou on 17/2/10.
 */

public class ViewBinder {

    private static final ActivityProvider ACTIVITY_PROVIDER = new ActivityProvider();
    private static final ViewProvider VIEW_PROVIDER = new ViewProvider();

    private static final Map<String, Finder> FINDER_MAP = new HashMap<>();
    /**
     * Activity的控件绑定
     *
     * @param activity
     */
    public static void bind(Activity activity) {
        bind(activity, activity, ACTIVITY_PROVIDER);
    }

    /**
     * Fragment的控件绑定
     *
     * @param subscribe fragment
     * @param view      view
     */
    public static void bind(Object subscribe, View view) {
        bind(subscribe, view, VIEW_PROVIDER);
    }

    /**
     * View的控件绑定
     *
     * @param view view
     */
    public static void bind(View view) {
        bind(view, view);
    }

    /**
     * 绑定
     *
     * @param subscribe 绑定的对象容器
     * @param source    绑定的对象来源
     * @param provider  提供者
     */
    public static void bind(Object subscribe, Object source, Provider provider) {
        String className = subscribe.getClass().getName();

        try {
            Finder finder = FINDER_MAP.get(className);
            if (finder == null) {
                Class<?> findClass = Class.forName(className + "$$Finder");
                finder = (Finder) findClass.newInstance();
                FINDER_MAP.put(className, finder);
            }
            finder.bind(subscribe, source, provider);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
