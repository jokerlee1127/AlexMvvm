package com.ly.common.mvvm.viewmodel;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;


import com.ly.common.mvvm.livedata.SingleLiveData;
import com.ly.common.mvvm.model.BaseModel;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;


/**
 * Description: <BaseViewModel><br>
 * Author:      mxdl<br>
 * Date:        2019/06/30<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class BaseViewModel<M extends BaseModel> extends AndroidViewModel implements IBaseViewModel, Consumer<Disposable> {
    protected M mModel;
    protected UIChangeLiveData mUIChangeLiveData;

    public BaseViewModel(@NonNull Application application, M model) {
        super(application);
        this.mModel = model;
    }
    public UIChangeLiveData getUC() {
        if (mUIChangeLiveData == null) {
            mUIChangeLiveData = new UIChangeLiveData();
        }
        return mUIChangeLiveData;
    }

    public final class UIChangeLiveData extends SingleLiveData {
        private SingleLiveData<Boolean> showInitLoadViewEvent;
        private SingleLiveData<Boolean> showTransLoadingViewEvent;
        private SingleLiveData<Boolean> showNoDataViewEvent;
        private SingleLiveData<Boolean> showNetWorkErrViewEvent;
        private SingleLiveData<Map<String, Object>> startActivityEvent;
        private SingleLiveData<Void> finishActivityEvent;
        private SingleLiveData<Void> onBackPressedEvent;

        public SingleLiveData<Boolean> getShowInitLoadViewEvent() {
            return showInitLoadViewEvent = createLiveData(showInitLoadViewEvent);
        }

        public SingleLiveData<Boolean> getShowTransLoadingViewEvent() {
            return showTransLoadingViewEvent = createLiveData(showTransLoadingViewEvent);
        }

        public SingleLiveData<Boolean> getShowNoDataViewEvent() {
            return showNoDataViewEvent = createLiveData(showNoDataViewEvent);
        }

        public SingleLiveData<Boolean> getShowNetWorkErrViewEvent() {
            return showNetWorkErrViewEvent = createLiveData(showNetWorkErrViewEvent);
        }

        public SingleLiveData<Map<String, Object>> getStartActivityEvent() {
            return startActivityEvent = createLiveData(startActivityEvent);
        }

        public SingleLiveData<Void> getFinishActivityEvent() {
            return finishActivityEvent = createLiveData(finishActivityEvent);
        }

        public SingleLiveData<Void> getOnBackPressedEvent() {
            return onBackPressedEvent = createLiveData(onBackPressedEvent);
        }
    }
    protected SingleLiveData createLiveData(SingleLiveData liveData) {
        if (liveData == null) {
            liveData = new SingleLiveData();
        }
        return liveData;
    }
    public static final class ParameterField {
        public static String CLASS = "CLASS";
        public static String CANONICAL_NAME = "CANONICAL_NAME";
        public static String BUNDLE = "BUNDLE";
    }

    public void postShowInitLoadViewEvent(boolean show) {
        if (mUIChangeLiveData != null) {
            mUIChangeLiveData.showInitLoadViewEvent.postValue(show);
        }
    }

    public void postShowNoDataViewEvent(boolean show) {
        if (mUIChangeLiveData != null) {
            mUIChangeLiveData.showNoDataViewEvent.postValue(show);
        }
    }

    public void postShowTransLoadingViewEvent(boolean show) {
        if (mUIChangeLiveData != null) {
            mUIChangeLiveData.showTransLoadingViewEvent.postValue(show);
        }
    }

    public void postShowNetWorkErrViewEvent(boolean show) {
        if (mUIChangeLiveData != null) {
            mUIChangeLiveData.showNetWorkErrViewEvent.postValue(show);
        }
    }
    public void postStartActivityEvent(Class<?> clz, Bundle bundle) {
        Map<String, Object> params = new HashMap<>();
        params.put(ParameterField.CLASS, clz);
        if (bundle != null) {
            params.put(ParameterField.BUNDLE, bundle);
        }
        mUIChangeLiveData.startActivityEvent.postValue(params);
    }


    public void postFinishActivityEvent() {
        mUIChangeLiveData.finishActivityEvent.call();
    }


    public void postOnBackPressedEvent() {
        mUIChangeLiveData.onBackPressedEvent.call();
    }


    @Override
    public void onAny(LifecycleOwner owner, Lifecycle.Event event) {

    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void accept(Disposable disposable) throws Exception {
        if(mModel != null){
            mModel.addSubscribe(disposable);
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (mModel != null) {
            mModel.onCleared();
        }
    }


}
