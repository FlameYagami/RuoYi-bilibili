package com.ruoyi.http.service;

import com.ruoyi.http.model.UpdateInfo;

import retrofit2.Call;

/**
 * Created by Flame on 2020/03/25.
 **/
public class TestApi extends BaseApi {

    public static class TestHolder {
        static TestApiService apiService = apiService(TestApiService.baseUrl, TestApiService.class);
    }

    public static Call<UpdateInfo> checkAppUpdate(String versionName) {
        return TestHolder.apiService.checkUpdate("android", versionName);
    }
}
