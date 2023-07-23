package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Test;
import com.jiawa.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController//返回字符串
//@Controller//返回页面
public class TestController {
    @Value("${test.hello:TEST}")
    private String testHello;
    @Resource
    private TestService testService;
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
}
