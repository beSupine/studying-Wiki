package com.jiawa.wiki.controller;

import com.jiawa.wiki.req.UserQueryReq;
import com.jiawa.wiki.req.UserSaveReq;
import com.jiawa.wiki.resp.CommonResp;
import com.jiawa.wiki.resp.UserQueryResp;
import com.jiawa.wiki.resp.PageResp;
import com.jiawa.wiki.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController//返回字符串
@RequestMapping("/user")
//@Controller//返回页面
public class UserController {

    @Resource
    private UserService userService;
    /**
     * GET,POST,PUT,DELETE分别对应查询，新增，修改，删除
     */
    @GetMapping("/list")
    public CommonResp list(@Valid UserQueryReq req) {
        CommonResp<PageResp<UserQueryResp>> resp = new CommonResp<>();
        PageResp<UserQueryResp> list = userService.list(req);
        resp.setContent(list);
        return resp;
    }
    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody UserSaveReq req) {
        CommonResp resp = new CommonResp<>();
        userService.save(req);
        return resp;
    }
    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        userService.delete(id);
        return resp;
    }
}
