package com.ruoyi.web.controller.demo.bo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RelationStatusChart {
    private String date;
    private long count;
}
