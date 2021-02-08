package com.ruoyi.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.TimeUtils;
import com.ruoyi.web.controller.demo.bo.RelationChart;
import com.ruoyi.web.controller.demo.bo.RelationStatusChart;
import com.ruoyi.web.controller.demo.entity.RelationStatus;
import com.ruoyi.web.mapper.BilibiliMapper;
import com.ruoyi.web.service.intf.IBilibiliService;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BilibiliService extends ServiceImpl<BilibiliMapper, RelationStatus> implements IBilibiliService {

    @Override
    public LinkedHashMap<String, Long> listOfMinMaps() {
        QueryWrapper<RelationStatus> queryWrapper = new QueryWrapper<RelationStatus>()
                .apply("create_date BETWEEN date_add(now(), INTERVAL - {0} minute) AND now()", 60);
        return listOfMaps(queryWrapper, TimeUtils.Format_Minute);
    }

    @Override
    public LinkedHashMap<String, Long> listOfHourMaps() {
        QueryWrapper<RelationStatus> queryWrapper = new QueryWrapper<RelationStatus>()
                .apply("create_date BETWEEN date_add(now(), INTERVAL - {0} hour) AND now()", 24);
        return listOfMaps(queryWrapper, TimeUtils.Format_Hour);
    }

    @Override
    public LinkedHashMap<String, Long> listOfDayMaps() {
        QueryWrapper<RelationStatus> queryWrapper = new QueryWrapper<RelationStatus>()
                .apply("create_date BETWEEN date_add(now(), INTERVAL - {0} day) AND now()", 30);
        return listOfMaps(queryWrapper, TimeUtils.Format_Day);
    }

    @Override
    public LinkedHashMap<String, Float> listOfMaps() {
        QueryWrapper<RelationStatus> queryWrapper = new QueryWrapper<RelationStatus>()
                .apply("create_date BETWEEN date_add(now(), INTERVAL - {0} hour) AND now()", 48);
        List<RelationChart> charts = list(queryWrapper).stream().map(it ->
            new RelationChart()
                    .setDate(TimeUtils.dateToString(it.getCreateDate(), TimeUtils.Format_Hour))
                    .setFollower((float) it.getFollower() / 1000000f)
        ).collect(Collectors.toList());
        charts.remove(0);
        charts.remove(charts.size() - 1);
        LinkedHashMap<String, Float> map = new LinkedHashMap<>();
        charts.forEach(it -> map.put(it.getDate(), it.getFollower()));
        return map;
    }

    private LinkedHashMap<String, Long> listOfMaps(QueryWrapper<RelationStatus> queryWrapper, String format){
        List<RelationStatusChart> charts = list(queryWrapper).stream()
                .collect(Collectors.groupingBy(it -> TimeUtils.dateToString(it.getCreateDate(), format)))
                .entrySet().stream()
                .map(entry -> {
                    List<RelationStatus> value = entry.getValue();
                    long num = value.get(0).getFollower() - entry.getValue().get(value.size() - 1).getFollower();
                    return new RelationStatusChart()
                            .setDate(entry.getKey())
                            .setCount(num);
                })
                .collect(Collectors.toList());
        charts.remove(0);
        charts.remove(charts.size() - 1);
        LinkedHashMap<String, Long> map = new LinkedHashMap<>();
        charts.forEach(it -> map.put(it.getDate(), it.getCount()));
        return map;
    }
}
