package com.qf.controller;

import com.qf.pojo.Student;
import com.qf.service.AdminService;
import com.qf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * author:赖文熙
 * date:2019/7/16 10:00
 * description:
 */

@Controller
public class StudentController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private StudentService studentService;

    //跳转学生页面
    @RequestMapping("student")
    public ModelAndView toStudent(int sid){
        ModelAndView modelAndView = new ModelAndView();
        Student student = studentService.getStudentBySid(sid);
        modelAndView.setViewName("student");
        modelAndView.addObject("student",student);
        return modelAndView;
    }

    //跳转修改页面
    @RequestMapping("student_change")
    public ModelAndView changeMessage(int sid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stu_update");
        Student student = studentService.getStudentBySid(sid);
        modelAndView.addObject("student",student);
        return modelAndView;
    }

    //修改并跳转成功页面
    @RequestMapping("stu_update")
    public ModelAndView updateStudent(Student student){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stu_success");
        studentService.updateStudent(student);
        Student student1 = studentService.getStudentBySid(student.getSid());
        modelAndView.addObject("student",student1);
        modelAndView.addObject("message","个人信息修改成功");
        return modelAndView;
    }



}
