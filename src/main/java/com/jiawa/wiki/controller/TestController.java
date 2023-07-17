package com.jiawa.wiki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//返回字符串
//@Controller//返回页面
public class TestController {
    /**
     * GET,POST,PUT,DELETE分别对应查询，新增，修改，删除
     * @return
     */
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
