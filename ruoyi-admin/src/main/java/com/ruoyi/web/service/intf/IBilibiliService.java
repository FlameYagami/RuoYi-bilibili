package com.ruoyi.web.service.intf;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.web.controller.demo.entity.RelationStatus;

import java.util.LinkedHashMap;
import java.util.Map;

public interface IBilibiliService extends IService<RelationStatus> {

    LinkedHashMap<String, Long> listOfMinMaps();

    LinkedHashMap<String, Long> listOfHourMaps();

    LinkedHashMap<String, Long> listOfDayMaps();

    LinkedHashMap<String, Float> listOfMaps();
}
