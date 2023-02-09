package com.ly.base_module.provider;


import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Description: <IHomeProvider>
 * Author:      alex
 * Update:
 */
public interface IHomeProvider extends IProvider {
    Fragment getHomeFragment();
}
