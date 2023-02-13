package com.ly.module_main;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.ly.base_module.provider.IHomeProvider;
import com.ly.base_module.provider.IMessageProvider;
import com.ly.base_module.provider.IMineProvider;
import com.ly.base_module.provider.ISquareProvider;
import com.ly.common.mvvm.BaseActivity;
import com.ly.module_main.entity.MainChannel;

public class MainActivity extends BaseActivity {

    @Autowired(name = "/home/main")
    IHomeProvider mHomeProvider;
    @Autowired(name = "/square/main")
    ISquareProvider mSquareProvider;
    @Autowired(name = "/message/main")
    IMessageProvider mMessageProvider;
    @Autowired(name = "/mine/main")
    IMineProvider mMineProvider;

    private Fragment mHomeFragment;
    private Fragment mSquareFragment;
    private Fragment mMessageFragment;
    private Fragment mMineFragment;
    private Fragment mCurrFragment;


    @Override
    public int onBindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        BottomNavigationView navigation = findViewById(R.id.nav);
        navigation.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {


                int i = item.getItemId();
                if (i == R.id.menu_home) {
                    switchContent(mCurrFragment, mHomeFragment, MainChannel.HOME.name);
                    mCurrFragment = mHomeFragment;


                } else if (i == R.id.menu_square) {
                    switchContent(mCurrFragment, mSquareFragment, MainChannel.SQUARE.name);
                    mCurrFragment = mSquareFragment;

                } else if (i == R.id.menu_message) {
                    switchContent(mCurrFragment, mMessageFragment, MainChannel.MESSAGE.name);
                    mCurrFragment = mMessageFragment;
                } else if (i == R.id.menu_mine) {
                    switchContent(mCurrFragment, mMineFragment, MainChannel.MINE.name);
                    mCurrFragment = mMineFragment;

                }
            }
        });

        if (mHomeProvider != null) {
            mHomeFragment = mHomeProvider.getHomeFragment();
        }
        if (mSquareProvider != null) {
            mSquareFragment = mSquareProvider.getSquareFragment();
        }

        if (mMessageProvider != null) {
            mMessageFragment = mMessageProvider.getMessageFragment();
        }
        if (mMineProvider != null) {
            mMineFragment = mMineProvider.getMineFragment();
        }
        mCurrFragment = mHomeFragment;
        if (mHomeFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, mHomeFragment, MainChannel.HOME.name).commit();
        }


    }

    @Override
    public void initData() {

    }

    public void switchContent(Fragment from, Fragment to, String tag) {
        if (from == null || to == null) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!to.isAdded()) {
            transaction.hide(from).add(R.id.frame_content, to, tag).commit();
        } else {
            transaction.hide(from).show(to).commit();
        }
    }
}
