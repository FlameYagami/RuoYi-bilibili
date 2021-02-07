package com.ruoyi.web.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.controller.demo.dto.RealtimeData;
import com.ruoyi.web.manager.RedisManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/report")
public class ReportController extends BaseController {

    private String prefix = "report";

    @Autowired
    public ReportController() {

    }

    /**
     * 首页头部数据获取
     */
    @PostMapping("/index/realtimeData")
    @ResponseBody
    public AjaxResult realtimeData() {
        RealtimeData realtimeData = new RealtimeData();
        realtimeData.setFollower(RedisManager.getInstance().getFollower());
        realtimeData.setFollowerStatus(RedisManager.getInstance().getFollowerStatus());
        return AjaxResult.success(realtimeData);
    }
}
