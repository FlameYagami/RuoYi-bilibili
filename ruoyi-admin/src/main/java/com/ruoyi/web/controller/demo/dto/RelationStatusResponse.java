package com.ruoyi.web.controller.demo.dto;

import com.ruoyi.web.controller.demo.entity.RelationStatus;

import lombok.Data;

/**
 * Created by Flame on 2021/02/07.
 **/

@Data
public class RelationStatusResponse {
    private long code;
    private String message;
    private long ttl;
    private RelationStatus data;
}
