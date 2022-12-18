package com.github.shoothzj.redis.controller;

import com.github.shoothzj.redis.service.RedisLuaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class LuaLockController {

    @Autowired
    private RedisLuaService redisLuaService;

    @GetMapping(path = "/lock")
    public void lock() {
        final String uuid = UUID.randomUUID().toString();
        redisLuaService.lock("key", uuid, 5);
    }

    @GetMapping(path = "/lock-all")
    public void lockAll() {
        final String uuid = UUID.randomUUID().toString();
        redisLuaService.lock("key", uuid, 5);
        redisLuaService.unLock("key", uuid);
    }

}
