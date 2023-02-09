package com.ly.base_module.user.factory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ly.base_module.user.login.LoginModel;
import com.ly.base_module.user.login.LoginViewModel;


/* Description: <ViewModelFactory><br>
 */
public class UserViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile UserViewModelFactory INSTANCE;
    private final Application mApplication;

    public static UserViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (UserViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserViewModelFactory(application);
                }
            }
        }
        return INSTANCE;
    }
    private UserViewModelFactory(Application application) {
        this.mApplication = application;
    }
    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(mApplication, new LoginModel(mApplication));
        }
//        else if (modelClass.isAssignableFrom(NewsListViewModel.class)) {
//            return (T) new NewsListViewModel(mApplication, new NewsListModel(mApplication));
//        }else if (modelClass.isAssignableFrom(NewsTypeViewModel.class)) {
//            return (T) new NewsTypeViewModel(mApplication, new NewsTypeModel(mApplication));
//        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
