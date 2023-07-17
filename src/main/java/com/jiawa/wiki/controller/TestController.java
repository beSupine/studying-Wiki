package com.jiawa.wiki.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//返回字符串
//@Controller//返回页面
public class TestController {
    /**
     * GET,POST,PUT,DELETE分别对应查询，新增，修改，删除
     * @return
     */
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
    @PostMapping("/hello/post")
    public String helloPost(String name) {
        return ("Hello World,"+name);
    }
}
