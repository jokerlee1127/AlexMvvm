package com.dp.module_message.fragment;

import android.view.View;

import com.dp.module_message.R;
import com.ly.common.mvvm.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: <MainNewsFragment><br>
 * Author:      mxdl<br>
 * Date:        2018/12/27<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MessageFragment extends BaseFragment {

    public static MessageFragment newInstance() {
        return new MessageFragment();
    }

    @Override
    public int onBindLayout() {
        return R.layout.fragment_message;
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
        //mViewPager.setOffscreenPageLimit(mListFragments.size());
    }


}
