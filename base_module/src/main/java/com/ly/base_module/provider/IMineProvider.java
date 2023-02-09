package com.ly.base_module.provider;


import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Description: <IMeProvider>
 * Version:     V1.0.0
 * Update:
 */
public interface IMineProvider extends IProvider {
    Fragment getMineFragment();
}
