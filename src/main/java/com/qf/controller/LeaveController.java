package com.qf.controller;

import com.qf.pojo.Leave;
import com.qf.pojo.Student;
import com.qf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * author: liu
 * date: 2019/7/16 10:39
 * info :
 */
@Controller
@RequestMapping("leave")
public class LeaveController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("goAdd")
    public String goAdd(){

        return "stu_index";

    }

    @RequestMapping("addLeave")
    public String addLeave(Leave leave, Model model, HttpSession session){

        Student user = (Student) session.getAttribute("user");

        int i = studentService.addStudentLeave(leave);

        return "stu_index";

    }



}
