package com.ruoyi.web.manager;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RedisManager {

    @Resource
    public RedisTemplate<String, Object> redisTemplate;

    private final String FOLLOWER        = "Follower";
    private final String FOLLOWER_STATUS = "Follower_Status";

    private static class RedisManagerHolder {
        public static RedisManager INSTANCE = new RedisManager();
    }

    public static RedisManager getInstance() {
        return RedisManagerHolder.INSTANCE;
    }

    @PostConstruct
    public void init() {
        getInstance().redisTemplate = redisTemplate;
    }

    public void syncFollower(long count) {
        redisTemplate.opsForValue().set(FOLLOWER, count);
    }

    public void syncFollowerStatus(long count) {
        redisTemplate.opsForValue().set(FOLLOWER_STATUS, count);
    }

    public long getFollower() {
        Object count = redisTemplate.opsForValue().get(FOLLOWER);
        if (StringUtils.isEmpty(count)) {
            return 0;
        }
        return Long.valueOf((Integer) count);
    }

    public long getFollowerStatus() {
        Object count = redisTemplate.opsForValue().get(FOLLOWER_STATUS);
        if (StringUtils.isEmpty(count)) {
            return 0;
        }
        return Long.valueOf((Integer) count);
    }
}
