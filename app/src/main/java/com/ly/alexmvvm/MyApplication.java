package com.ly.alexmvvm;

import android.app.Application;

import com.ly.base_module.AppUtils;
import com.ly.common.BaseApplication;
import com.ly.common.util.ToastUtil;

public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        AppUtils.init(this);
        ToastUtil.showToast("this is test");
    }
}
