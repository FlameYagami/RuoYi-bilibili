package com.ruoyi.web.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.controller.demo.dto.RealtimeData;

import com.ruoyi.web.manager.RedisManager;
import com.ruoyi.web.service.intf.IBilibiliService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/report")
public class ReportController extends BaseController {

    private String prefix = "report";

    private final IBilibiliService ibilibiliService;

    @Autowired
    public ReportController(IBilibiliService ibilibiliService) {
        this.ibilibiliService = ibilibiliService;
    }

    @PostMapping("/index/realtimeData")
    @ResponseBody
    public AjaxResult realtimeData() {
        RealtimeData realtimeData = new RealtimeData();
        realtimeData.setFollower(RedisManager.getInstance().getFollower());
        realtimeData.setFollowerStatus(RedisManager.getInstance().getFollowerStatus());
        return AjaxResult.success(realtimeData);
    }

    @PostMapping("/index/relationStatusChart")
    @ResponseBody
    public AjaxResult relationStatusChart(@Param("type") String type) {
        if ("h".equals(type)){
            return AjaxResult.success(ibilibiliService.listOfHourMaps());
        }
        if ("d".equals(type)){
            return AjaxResult.success(ibilibiliService.listOfDayMaps());
        }
        return AjaxResult.success(ibilibiliService.listOfMinMaps());
    }

    @PostMapping("/index/relationChart")
    @ResponseBody
    public AjaxResult relationChart() {
        return AjaxResult.success(ibilibiliService.listOfMaps());
    }
}
