package com.viewbinder.api;

import com.viewbinder.api.provider.Provider;

/**
 * Created by zhouyou on 17/2/10.
 */

public interface Finder<T> {

    void bind(T subscribe, Object source, Provider provider);
}
