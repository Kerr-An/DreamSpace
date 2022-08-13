package com.dingqing.controller;

import com.dingqing.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2002-2022, 希音
 *
 * @FileName: test
 * @Author: SunJian
 * @Date: 2022/8/7 03:14
 * @Description: TODO //模块目的、功能描述
 */
@RestController
@RequestMapping("admin/user")
public class test {

    @RequestMapping("/getUser")
    private String test1() {
        return User.builder().name("Lucy").age(11).build().toString();
    }
}