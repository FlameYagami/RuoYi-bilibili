package com.ruoyi.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.web.controller.demo.entity.RelationStatus;
import com.ruoyi.web.mapper.BilibiliMapper;
import com.ruoyi.web.service.intf.IbilibiliService;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BilibiliService extends ServiceImpl<BilibiliMapper, RelationStatus> implements IbilibiliService {

}
