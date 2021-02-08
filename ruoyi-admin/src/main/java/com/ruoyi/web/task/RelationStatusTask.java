package com.ruoyi.web.task;

import com.ruoyi.common.utils.GsonUtils;
import com.ruoyi.http.func.CallbackFunc;
import com.ruoyi.web.api.BilibiliApi;
import com.ruoyi.web.controller.demo.dto.RelationStatusResponse;
import com.ruoyi.web.service.intf.IBilibiliService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Flame on 2021/02/07.
 **/

@Component("syncRelationStatusTask")
@Slf4j
public class RelationStatusTask {

    private final IBilibiliService ibilibiliService;

    @Autowired
    public RelationStatusTask(IBilibiliService ibilibiliService) {
        this.ibilibiliService = ibilibiliService;
    }

    public void start() {
        BilibiliApi.relationStatus(777536).enqueue(new CallbackFunc<RelationStatusResponse>() {

            @Override
            public void onResponse(RelationStatusResponse response) {

//                long status = response.getData().getFollower() - RedisManager.getInstance().getFollower();
//                RedisManager.getInstance().syncFollowerStatus(status);
//                RedisManager.getInstance().syncFollower(response.getData().getFollower());
//                ibilibiliService.save(response.getData());
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }
}
