package com.dp.module_mine.fragment;

import android.view.View;

import com.dp.module_mine.R;
import com.ly.common.mvvm.BaseFragment;
import com.ly.common.view.SettingBarView;


/**
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MineFragment extends BaseFragment {

    private SettingBarView mSetNewsType;
    private SettingBarView mSetNewsDetail;

    public static MineFragment newInstance() {
        return new MineFragment();
    }


    @Override
    public int onBindLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView(View view) {
    }

    @Override
    public void initData() {

    }

    @Override
    public String getToolbarTitle() {
        return null;
    }

    @Override
    public void initListener() {


    }


}
