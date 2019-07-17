package com.qf.controller;

import com.qf.pojo.Leave;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.service.LeaveService;
import com.qf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    @Autowired
    private LeaveService leaveService;

    @RequestMapping("goAdd")
    public String goAdd(){

        return "stu_index";

    }

    @RequestMapping("addLeave")
    public String addLeave(Leave leave, Model model, HttpSession session){

        Student student = (Student) session.getAttribute("student");

        User user = new User();
        user.setId(student.getSid());
        user.setName(student.getSname());
        leave.setUser(user);
        int i = studentService.addStudentLeave(leave);

        return "student";

    }

    /**
     * 查看待办假条
     */
    @RequestMapping("getLeaves")
    public String getLeaves(HttpSession session, Model model){

        User user = (User) session.getAttribute("user");

        List<Leave> leaves = leaveService.queryLeaveList(user.getName());

        model.addAttribute("leaves", leaves);

        return "leaveList";

    }


    /**
     * 审批假条
     * @return
     */
    @RequestMapping(value = "updateLeave",produces = "application/json;charset=utf8")
    @ResponseBody
    public Integer update(Integer lid, HttpSession session){

        User user = (User) session.getAttribute("user");

        int i = leaveService.updateLeave(lid, user.getName());

        return i;

    }

    /**
     * 员工请假
     */
    @RequestMapping("empLeave")
    public String empLeave(Leave leave, HttpSession session){

        User user = (User) session.getAttribute("user");
        leave.setUser(user);

        int i = leaveService.addLeave(leave);
        return "redirect:../Staff";

    }





}
