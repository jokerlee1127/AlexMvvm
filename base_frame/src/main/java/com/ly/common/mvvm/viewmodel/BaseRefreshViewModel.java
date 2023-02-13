package com.ly.common.mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;

import com.ly.common.binding.command.BindingAction;
import com.ly.common.binding.command.BindingCommand;
import com.ly.common.mvvm.livedata.SingleLiveData;
import com.ly.common.mvvm.model.BaseModel;


/**
 * Description: <BaseRefreshViewModel><br>
 * Author:      mxdl<br>
 * Date:        2019/06/30<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public abstract class BaseRefreshViewModel<T, M extends BaseModel> extends BaseViewModel<M> {
    protected ObservableArrayList<T> mList = new ObservableArrayList<>();
    public ObservableField<Boolean> orientation = new ObservableField();
    public ObservableField<Boolean> enableLoadMore = new ObservableField();
    public ObservableField<Boolean>  enableRefresh = new ObservableField();

    public BaseRefreshViewModel(@NonNull Application application, M model) {
        super(application, model);
        enableLoadMore.set(enableLoadMore());
        enableRefresh.set(enableRefresh());
    }
    public boolean enableLoadMore(){
        return true;
    }
    public boolean enableRefresh(){
        return true;
    }
    protected UIChangeRefreshLiveData mUIChangeRefreshLiveData;

    public UIChangeRefreshLiveData getUCRefresh() {
        if (mUIChangeRefreshLiveData == null) {
            mUIChangeRefreshLiveData = new UIChangeRefreshLiveData();
        }
        return mUIChangeRefreshLiveData;
    }

    public final class UIChangeRefreshLiveData extends SingleLiveData {
        private SingleLiveData<Void> mStopRefresLiveEvent;
        private SingleLiveData<Void> mAutoRefresLiveEvent;
        private SingleLiveData<Void> mStopLoadMoreLiveEvent;
        public SingleLiveData<Void> getStopRefresLiveEvent() {
            return mStopRefresLiveEvent = createLiveData(mStopRefresLiveEvent);
        }
        public SingleLiveData<Void> getAutoRefresLiveEvent() {
            return mAutoRefresLiveEvent = createLiveData(mAutoRefresLiveEvent);
        }
        public SingleLiveData<Void> getStopLoadMoreLiveEvent() {
            return mStopLoadMoreLiveEvent = createLiveData(mStopLoadMoreLiveEvent);
        }
    }
    public void postStopRefreshEvent(){
        if(mUIChangeRefreshLiveData != null){
            mUIChangeRefreshLiveData.getStopRefresLiveEvent().call();
        }
    }
    public void postAutoRefreshEvent(){
        if(mUIChangeRefreshLiveData != null){
            mUIChangeRefreshLiveData.getAutoRefresLiveEvent().call();
        }
    }
    public void postStopLoadMoreEvent(){
        if(mUIChangeRefreshLiveData != null){
            mUIChangeRefreshLiveData.mStopLoadMoreLiveEvent.call();
        }
    }
    public ObservableArrayList<T> getList() {
        return mList;
    }

    public BindingCommand onRefreshCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            refreshData();
        }
    });
    public BindingCommand onLoadMoreCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            loadMore();
        }
    });
    public BindingCommand onAutoRefreshCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            refreshData();
        }
    });

    public abstract void refreshData();

    public abstract void loadMore();

}
