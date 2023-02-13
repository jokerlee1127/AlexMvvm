package com.dp.module_square.provider;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dp.module_square.fragment.SquareFragment;
import com.ly.base_module.provider.ISquareProvider;

/**
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
@Route(path = "/square/main", name = "广场")
public class SquareProvider implements ISquareProvider {

    @Override
    public void init(Context context) {

    }

    @Override
    public Fragment getSquareFragment() {
        return SquareFragment.newInstance();
    }
}
