package com.dp.module_mine.provider;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dp.module_mine.fragment.MineFragment;
import com.ly.base_module.provider.IMineProvider;

/**
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
@Route(path = "/mine/main", name = "个人中心")
public class MineProvider implements IMineProvider {
    @Override
    public Fragment getMineFragment() {
        return MineFragment.newInstance();
    }

    @Override
    public void init(Context context) {

    }
}
