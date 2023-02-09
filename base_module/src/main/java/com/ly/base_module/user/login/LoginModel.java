package com.ly.base_module.user.login;

import android.app.Application;


import com.ly.base_module.AppUtils;
import com.ly.common.http.RespBase;
import com.ly.common.http.RetrofitManager;
import com.ly.common.http.RxAdapter;
import com.ly.common.mvvm.model.BaseModel;

import io.reactivex.rxjava3.core.Observable;

public class LoginModel extends BaseModel {
    private LoginApi loginApi;

    public LoginModel(Application application) {
        super(application);
        loginApi = RetrofitManager.getInstance().create(LoginApi.class);
    }


    public Observable<RespBase<LoginBean>> login(LoginParam param) {
        return loginApi.login(AppUtils.ParamsToBody(param))
                .compose(RxAdapter.schedulersTransformer())
                .compose(RxAdapter.exceptionTransformer());
    }


}