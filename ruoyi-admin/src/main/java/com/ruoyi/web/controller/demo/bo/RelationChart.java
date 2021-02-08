package com.ruoyi.web.controller.demo.bo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RelationChart {
    private String date;
    private float follower;
}
