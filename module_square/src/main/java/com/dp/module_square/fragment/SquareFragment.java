package com.dp.module_square.fragment;

import android.view.View;

import com.dp.module_square.R;
import com.ly.common.mvvm.BaseFragment;


/**
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class SquareFragment extends BaseFragment {


    public static SquareFragment newInstance() {
        return new SquareFragment();
    }


    @Override
    public int onBindLayout() {
        return R.layout.fragment_square;
    }

    @Override
    public void initView(View view) {
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public String getToolbarTitle() {
        return null;
    }


}
