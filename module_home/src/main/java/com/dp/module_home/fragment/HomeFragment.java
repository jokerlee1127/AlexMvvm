package com.dp.module_home.fragment;

import android.util.Log;
import android.view.View;


import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.dp.module_home.R;
import com.ly.base_module.user.factory.UserViewModelFactory;
import com.ly.base_module.user.login.LoginBean;
import com.ly.base_module.user.login.LoginParam;
import com.ly.base_module.user.login.LoginViewModel;
import com.ly.common.mvvm.BaseMvvmFragment;


public class HomeFragment extends BaseMvvmFragment<ViewDataBinding, LoginViewModel> {

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public int onBindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {
    }

    @Override
    public void initData() {
        LoginParam param = new LoginParam();
        param.setMobile("18601676820");
        param.setPassword("lee1127925");
        mViewModel.login(param);


    }

    @Override
    public void initListener() {
        //mViewPager.setOffscreenPageLimit(mListFragments.size());
    }


    @Override
    public Class<LoginViewModel> onBindViewModel() {
        return LoginViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return (ViewModelProvider.Factory) UserViewModelFactory.getInstance(mActivity.getApplication());
    }

    @Override
    public void initViewObservable() {
        mViewModel.getLoginSingleLiveData().observe(this, loginBean -> Log.e("sax", "loginBean: " + loginBean));
    }

    @Override
    public int onBindVariableId() {
        return 0;
    }


    @Override
    public String getToolbarTitle() {
        return null;
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

    }
}
