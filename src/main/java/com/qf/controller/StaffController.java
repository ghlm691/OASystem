package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.Weekly;
import com.qf.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * author:jerry
 * date:2019/7/15 19:43
 * description:
 */
@Controller
public class StaffController {

    @Autowired
    private StaffService staffService;

    @RequestMapping("Staff")
    public String goStaff() {
        return "staff";
    }

    @RequestMapping("UpdatePassword")
    public String goUpdatePassword() {
        return "update_password";
    }

    @RequestMapping("AllWeekly")
    public ModelAndView getAll(@RequestParam(value = "pageNum",defaultValue = "1")int pageNum){
        ModelAndView modelAndView = new ModelAndView();
        PageHelper.startPage(pageNum,5);
        List<Weekly> weeklyList = staffService.queryAll();
        System.out.println(weeklyList.get(1));
        PageInfo pageInfo = new PageInfo(weeklyList);
        modelAndView.setViewName("all_weekly");
        modelAndView.addObject("pageInfo",pageInfo);
        return modelAndView;
    }
}
