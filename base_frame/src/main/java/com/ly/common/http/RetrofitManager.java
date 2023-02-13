package com.ly.common.http;

import android.app.Application;
import android.content.Context;

import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;

import java.net.Socket;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509ExtendedTrustManager;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Description: <RetrofitManager><br>
 * Author:      mxdl<br>
 * Date:        2019/6/22<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class RetrofitManager {
    public static RetrofitManager retrofitManager;
    public static Context mContext;
    private Retrofit mRetrofit;
    private OkHttpClient.Builder okHttpBuilder;
    private String mToken;
    private String baseUrl = "https://gateway-test.upingu.cn";


    private RetrofitManager() {
//        //给client的builder添加了一个日志拦截器
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        //打印网络请求日志
        LoggingInterceptor httpLoggingInterceptor = new LoggingInterceptor.Builder()
                .loggable(true)
                .setLevel(Level.BASIC)
                .log(Platform.INFO)
                .request("Log-Req")
                .response("Log_Res")
                .build();

        okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder.connectTimeout(20 * 1000, TimeUnit.MILLISECONDS).
                readTimeout(20 * 1000, TimeUnit.MILLISECONDS).
                writeTimeout(20 * 1000, TimeUnit.MILLISECONDS);

        okHttpBuilder.addInterceptor(httpLoggingInterceptor);
        okHttpBuilder.addInterceptor(chain -> {


            Request.Builder builder = chain.request().newBuilder();
            builder
                    .addHeader("Content-Type", "application/json")
                    .addHeader("client-version", "1.6.0")
                    .addHeader("platform", "android")
                    .addHeader("appId", "APP1594644083423")

                    .addHeader("deviceInfo", "SPUtils.getInstance().getString(Constants.DEVICE_NUMBER)");

//                if (!TextUtils.isEmpty(accessToken)) {
//                    builder.addHeader("X-ACCESS-TOKEN", accessToken);
//                }


            return chain.proceed(builder.build());
        });

        //给client的builder添加了一个socketFactory
        SSLContext sslContext = SSLContextUtil.getDefaultSLLContext();
        if (sslContext != null) {
            SSLSocketFactory socketFactory = sslContext.getSocketFactory();
            okHttpBuilder.sslSocketFactory(socketFactory, new X509ExtendedTrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s, Socket socket) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s, Socket socket) throws CertificateException {

                }

                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s, SSLEngine sslEngine) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s, SSLEngine sslEngine) throws CertificateException {

                }

                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            });
        }
        okHttpBuilder.hostnameVerifier(SSLContextUtil.HOSTNAME_VERIFIER);

        //创建client
        OkHttpClient okHttpClient = okHttpBuilder.build();
        mRetrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl + "")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static void init(Application application, String baseUrl) {
        mContext = application;
    }

    public static RetrofitManager getInstance() {
        if (retrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (retrofitManager == null) {
                    retrofitManager = new RetrofitManager();
                }
            }
        }
        return retrofitManager;
    }

    public <T> T create(Class<T> tClass) {
        return mRetrofit.create(tClass);
    }


    public void addToken(String token) {
        mToken = token;
    }
}