package com.dp.module_home.mvvm.factory;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ly.base_module.user.login.LoginModel;
import com.ly.base_module.user.login.LoginViewModel;


/* Description: <ViewModelFactory><br>
 */
public class NewsViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    @SuppressLint("StaticFieldLeak")
    private static volatile NewsViewModelFactory INSTANCE;
    private final Application mApplication;

    public static NewsViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (NewsViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NewsViewModelFactory(application);
                }
            }
        }
        return INSTANCE;
    }
    private NewsViewModelFactory(Application application) {
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
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
