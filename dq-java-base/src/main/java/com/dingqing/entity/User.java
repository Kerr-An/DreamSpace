package com.dingqing.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (C), 2002-2022, 希音
 *
 * @FileName: User
 * @Author: SunJian
 * @Date: 2022/8/7 01:38
 * @Description: TODO //模块目的、功能描述
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;
}