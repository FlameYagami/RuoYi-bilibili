package com.ruoyi.web.controller.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * Created by Flame on 2021/02/07.
 **/

@Data
@TableName("t_bilibili_relation_status")
public class RelationStatus {
    private long id;
    private long mid;
    private long follower;
}
