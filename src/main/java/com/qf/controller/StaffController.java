package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.Classes;
import com.qf.pojo.User;
import com.qf.pojo.Weekly;
import com.qf.service.StaffService;
import com.qf.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @RequestMapping("UpdatePwd")
    public String goUpdatePassword() {
        return "update_password";
    }

    @RequestMapping("WscoreManager")
    public String wscoreManager(){
        return "wscore_manager";
    }

    @RequestMapping("LeaveRequest")
    public String leaveRequest(){
        return "leave_request";
    }

    @RequestMapping("Error")
    public String goError() {
        return "error";
    }

    @RequestMapping("StudentScore")
    public  String goStudentScore(){
        return "student_score";
    }

    @RequestMapping("AllWeekly")
    public ModelAndView getAll(@RequestParam(value = "pageNum",defaultValue = "1")int pageNum, String method, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        Classes classes = (Classes)session.getAttribute("classes");
        modelAndView.addObject("classes ",classes );
        PageHelper.startPage(pageNum,5);
        if(method.equals("All")){
            List<Weekly> weeklyList = staffService.queryAll(classes.getCid());
            PageInfo pageInfo = new PageInfo(weeklyList);
            modelAndView.setViewName("all_weekly");
            modelAndView.addObject("pageInfo",pageInfo);
            return modelAndView;
        }else{
            List<Weekly> weeklyList = staffService.queryAlreadyMark(classes.getCid());
            PageInfo pageInfo = new PageInfo(weeklyList);
            modelAndView.setViewName("mark_weekly");
            modelAndView.addObject("pageInfo",pageInfo);
            return modelAndView;
        }
    }


    @RequestMapping("detail")
    public ModelAndView getDtail(Integer wid) {
        Weekly weekly = staffService.queryDetail(wid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("weekly", weekly);
        modelAndView.setViewName("detail");
        return modelAndView;
    }


    @RequestMapping("UpdateWscore")
    public ModelAndView updateWscore(Integer wid,Integer wscore ) {
        ModelAndView modelAndView = new ModelAndView();
        int i = staffService.updateWscore(wid, wscore);
        if (i != -1) {
            Weekly weekly = staffService.queryDetail(wid);
            modelAndView.addObject("weekly", weekly);
            modelAndView.setViewName("detail");
            return modelAndView;
        }else{
            modelAndView.setViewName("fail");
            return modelAndView;
        }

    }

    @RequestMapping(value = "/{wid}",method = RequestMethod.DELETE,produces = "application/json;charset=utf8")
    @ResponseBody
    public int delete (@PathVariable("wid") Integer wid){
        int i = staffService.deleteWeekly(wid);
        return i;
    }

    @RequestMapping("UpdatePassword")
    public ModelAndView updatePassword(String newPassword1,HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String password = null;
        try {
            password = MD5Utils.getMD5Str(newPassword1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        staffService.updatePassword(user.getId(),password);
        modelAndView.setViewName("staff");
        return modelAndView;
    }



    }

