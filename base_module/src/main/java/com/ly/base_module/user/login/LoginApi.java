package com.ly.base_module.user.login;


import com.ly.common.http.RespBase;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {
    @POST("/app/user/password/login")
    Observable<RespBase<LoginBean>> login(@Body RequestBody body);

}
