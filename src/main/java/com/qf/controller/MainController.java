package com.qf.controller;

import com.qf.pojo.Student;
import com.qf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * author:赖文熙
 * date:2019/7/15 12:01
 * description:主控制器
 */


@Controller
public class MainController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("index")
    public String goIndex() {
        return "login";
    }


    /**
     * 登录
     */
    @RequestMapping("login")
    public ModelAndView student(String username,String password){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        //认证身份
        //1.超级管理员
        //2.学生
        //set值
        Student student = studentService.getStudentByUnamePwd(username, password);
        modelAndView.addObject("student",student);
        modelAndView.setViewName("student");
        //3.讲师
        //4.班主任
        //5.校长
        return modelAndView;
    }

}
