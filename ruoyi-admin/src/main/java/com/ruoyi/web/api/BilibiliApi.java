package com.ruoyi.web.api;

import com.ruoyi.http.service.BaseApi;
import com.ruoyi.web.controller.demo.dto.RelationStatusResponse;

import retrofit2.Call;

/**
 * Created by Flame on 2020/03/25.
 **/
public class BilibiliApi extends BaseApi {

    public static class BilibiliHolder {
        static IBilibili apiService = apiService(IBilibili.baseUrl, IBilibili.class);
    }

    public static Call<RelationStatusResponse> relationStatus(long vmid) {
        return BilibiliHolder.apiService.relationStats(vmid);
    }

}
