package com.ruoyi.web.api;

import com.ruoyi.web.controller.demo.dto.RelationStatusResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Flame on 2020/03/25.
 **/
public interface IBilibili {

    String baseUrl = "http://api.bilibili.com/";

    @GET("x/relation/stat")
    Call<RelationStatusResponse> relationStats(
            @Query("vmid") long vmid
    );
}
