package com.ruoyi.http.service;

import com.ruoyi.http.model.UpdateInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Flame on 2020/03/25.
 **/
public interface TestApiService {

    String baseUrl = "http://cloud.mesmart.cc/mecloud/";

    @GET("smart_detectUpgrade")
    Call<UpdateInfo> checkUpdate(
            @Query("platform") String platform,
            @Query("upgradeVersion") String version
    );
}
