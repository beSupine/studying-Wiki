package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Demo;
import com.jiawa.wiki.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController//返回字符串
@RequestMapping("/demo")
//@Controller//返回页面
public class DemoController {

    @Resource
    private DemoService demoService;
    /**
     * GET,POST,PUT,DELETE分别对应查询，新增，修改，删除
     */
    @GetMapping("/list")
    public List<Demo> list() {
        return demoService.list();
    }
}
