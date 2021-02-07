package com.ruoyi.web;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@ComponentScan(basePackages = {"com.ruoyi"})
@MapperScan(value = {"com.**.**.mapper*"})
public class RuoYiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RuoYiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(RuoYiApplication.class);
    }
}