package com.ly.base_module;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.ly.common.http.RetrofitManager;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class AppUtils {
    private static String baseUrl = "https://gateway-test.upingu.cn";

    public static void init(Application application) {
        RetrofitManager.init(application, baseUrl);
    }

    private static final String TYPE="application/json; charset=utf-8";

    public static RequestBody ParamsToBody(Object o){
        Gson gson=new Gson();
        String json=gson.toJson(o);
        RequestBody body= RequestBody.create(MediaType.parse(TYPE), json);
        Log.d("body----",json);
        return body;
    }
}
