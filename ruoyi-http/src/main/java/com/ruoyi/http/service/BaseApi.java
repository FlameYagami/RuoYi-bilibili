package com.ruoyi.http.service;

import com.ruoyi.http.interceptor.LogInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Flame on 2020/03/25.
 **/
public abstract class BaseApi {

    private static final long DEFAULT_TIMEOUT = 5000; // 默认超时时间5秒

    private static class OkHttpClientHolder {
        public static OkHttpClient instance = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
                .addInterceptor(new LogInterceptor())
                .build();
    }

    public static <T> T apiService(String baseUrl, Class<T> tClass) {
        return new Retrofit.Builder()
                .client(OkHttpClientHolder.instance)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()
                .create(tClass);
    }
}
