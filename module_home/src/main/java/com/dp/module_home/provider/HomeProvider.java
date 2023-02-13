package com.dp.module_home.provider;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dp.module_home.fragment.HomeFragment;
import com.ly.base_module.provider.IHomeProvider;

/**
 * Description: <NewProvider><br>
 * Update:     <br>
 */
@Route(path = "/home/main", name = "首页")
public class HomeProvider implements IHomeProvider {

    @Override
    public void init(Context context) {

    }

    @Override
    public Fragment getHomeFragment() {
        return HomeFragment.newInstance();
    }
}
