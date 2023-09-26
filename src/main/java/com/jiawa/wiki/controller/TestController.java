package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Test;
import com.jiawa.wiki.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController//返回字符串
//@Controller//返回页面
public class TestController {
    public static final Logger LOG = LoggerFactory.getLogger(TestController.class);
    @Value("${test.hello:TEST}")
    private String testHello;
    @Resource
    private TestService testService;
    @Resource
    private RedisTemplate redisTemplate;
    /**
     * GET,POST,PUT,DELETE分别对应查询，新增，修改，删除
     */
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!"+testHello;
    }
    @PostMapping("/hello/post")
    public String helloPost(String name) {
        return ("Hello World,"+name);
    }
    @GetMapping("/test/list")
    public List<Test> list() {
        return testService.list();
    }


    @RequestMapping("/redis/set/{key}/{value}")
    public String set(@PathVariable Long key, @PathVariable String value) {
        redisTemplate.opsForValue().set(key, value, 3600, TimeUnit.SECONDS);
        LOG.info("key: {}, value: {}", key, value);
        return "success";
    }

    @RequestMapping("/redis/get/{key}")
    public Object get(@PathVariable Long key) {
        Object object = redisTemplate.opsForValue().get(key);
        LOG.info("key: {}, value: {}", key, object);
        return object;
    }
}
