package com.vividhdarote.journalismApp.service;


import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Disabled
    @Test
    @PostConstruct
    public void testRedis() {
        redisTemplate.opsForValue().set("ping", "pong");
        String value = redisTemplate.opsForValue().get("ping");
        System.out.println("Redis Test: " + value);
    }
}