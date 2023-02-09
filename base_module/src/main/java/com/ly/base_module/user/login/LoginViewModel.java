package com.ly.base_module.user.login;

import android.app.Application;

import androidx.annotation.NonNull;


import com.ly.common.http.RespBase;
import com.ly.common.mvvm.livedata.SingleLiveData;
import com.ly.common.mvvm.viewmodel.BaseViewModel;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class LoginViewModel extends BaseViewModel<LoginModel> {


    public LoginViewModel(@NonNull Application application, LoginModel model) {
        super(application, model);
    }

    private SingleLiveData<LoginBean> mListSingleLiveData;


    public void login(LoginParam param) {
        mModel.login(param).subscribe(new Observer<RespBase<LoginBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RespBase<LoginBean> listRespDTO) {
                getLoginSingleLiveData().postValue(listRespDTO.data);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
    public SingleLiveData<LoginBean> getLoginSingleLiveData() {
        return mListSingleLiveData = createLiveData(mListSingleLiveData);
    }

}