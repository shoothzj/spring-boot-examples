package com.github.shoothzj.redis.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Slf4j
@Service
public class RedisLuaService {

    Resource setLockSource = new ClassPathResource("lua/set_lock.lua");

    RedisScript<Boolean> lockScript = RedisScript.of(setLockSource, Boolean.class);

    Resource releaseLockSource = new ClassPathResource("lua/release_lock.lua");

    RedisScript<Boolean> releaseLockScript = RedisScript.of(releaseLockSource, Boolean.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void lock(String key, String lockId, int seconds) {
        final Boolean result = this.redisTemplate.execute(lockScript, Collections.singletonList(key), String.valueOf(seconds), lockId);
        log.info("result is {}", result);
    }

    public void unLock(String key, String lockId) {
        final Boolean result = this.redisTemplate.execute(releaseLockScript, Collections.singletonList(key), lockId);
        log.info("result is {}", result);
    }

}
