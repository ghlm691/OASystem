package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author:赖文熙
 * date:2019/7/15 12:01
 * description:主控制器
 */

@Controller
public class MainController {

    @RequestMapping("index")
    public String goIndex() {
        return "login";
    }
}
