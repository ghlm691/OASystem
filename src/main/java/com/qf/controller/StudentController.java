package com.qf.controller;

import com.qf.pojo.Student;
import com.qf.pojo.Weekly;
import com.qf.pojo.vo.WeeklyVO;
import com.qf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * author:赖文熙
 * date:2019/7/16 10:00
 * description:
 */
@Controller
public class StudentController {

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

    //退出
    @RequestMapping("stu_logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("oldPassword");
        return "login";
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

    //修改密码
    @RequestMapping("stu_password")
    public ModelAndView updatePassword(Student student){
        ModelAndView modelAndView = new ModelAndView();
        studentService.updatePassword(student.getSid(),student.getPassword());
        modelAndView.setViewName("stu_success");
        modelAndView.addObject("student",student);
        modelAndView.addObject("message","个人信息修改成功");
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

    //跳转添加周报页面
    @RequestMapping("student_addWeekly")
    public ModelAndView addWeekly(int sid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stu_addWeekly");
        System.out.println(sid);
        modelAndView.addObject("sid",sid);
        return modelAndView;
    }

    //跳转周报页面
    @RequestMapping("student_weekly")
    public ModelAndView weekly(int sid){
        ModelAndView modelAndView = new ModelAndView();
        List<Weekly> weeklyList = studentService.queryWeeklyForStudent(sid);
        modelAndView.addObject("weeklyList",weeklyList);
        modelAndView.addObject("sid",sid);
        modelAndView.setViewName("stu_weekly");
        return modelAndView;
    }

    //添加周报
    @RequestMapping("addWeekly")
    public ModelAndView addWeekly(WeeklyVO weeklyVO){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stu_success");
        Date date = new Date();
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
        String wtime = time.format(date);
        System.out.println(wtime);
        weeklyVO.setWtime(wtime);
        System.out.println(weeklyVO.getWscore());
        studentService.addWeekly(weeklyVO);
        Student student = new Student();
        student.setSid(weeklyVO.getUid());
        modelAndView.addObject("student",student);
        modelAndView.addObject("message","周报添加成功");
        return modelAndView;
    }

    //学生请假页面
    @RequestMapping("student_leave")
    public ModelAndView toLeave(int sid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stu_leave");
        modelAndView.addObject("sid",sid);
        return modelAndView;
    }



}
