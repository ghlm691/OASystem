package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.mapper.ScoreMapper;
import com.qf.pojo.Classes;
import com.qf.pojo.Score;
import com.qf.pojo.User;
import com.qf.pojo.Weekly;
import com.qf.pojo.vo.ScoreVO;
import com.qf.service.ScoreService;
import com.qf.service.StaffService;
import com.qf.utils.MD5Utils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private ScoreMapper scoreMapper;

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

    @RequestMapping("AddScore")
    public String goAddScore(){
        return "add_score";
    }

    @RequestMapping("Out")
    public String  out(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("oldPassword");
        return "login";
    }


    //跳转周报管理页面
    @RequestMapping("AllWeekly")
    public ModelAndView weeklyPage(Integer uid, @RequestParam(value = "pageNum",defaultValue = "1")int pageNum, String method, HttpServletRequest request){
        System.out.println(uid);
        ModelAndView modelAndView = new ModelAndView();
        //根据老师查询所教班级
        List<Classes> classList = scoreService.getClassByTid(uid);//班级列表
        modelAndView.addObject("classList",classList);
        PageHelper.startPage(pageNum,5);
        if(method.equals("All")){
            //展示第一个班级学生周报
            List<Weekly> weeklyList = staffService.queryAll(classList.get(0).getCid());
            System.out.println("weeklyList = " + weeklyList);
            modelAndView.addObject("weeklyList",weeklyList);
            PageInfo pageInfo = new PageInfo(weeklyList);
            modelAndView.addObject("pageInfo",pageInfo);
            modelAndView.setViewName("all_weekly");
            return modelAndView;
        }else{
            List<Weekly> weeklyList = staffService.queryAlreadyMark(classList.get(0).getCid());
            System.out.println("weeklyList = " + weeklyList);
            modelAndView.addObject("weeklyList",weeklyList);
            PageInfo pageInfo = new PageInfo(weeklyList);
            modelAndView.setViewName("mark_weekly");
            modelAndView.addObject("pageInfo",pageInfo);
            return modelAndView;
        }

    }


    //更新周报展示
    @RequestMapping(value = "changeWeekly",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String changeWeekly(int cid){
        System.out.println(cid);
        JSONObject json = new JSONObject();
        //展示所选班级
        List<Weekly> wList = staffService.queryAll(cid);
        System.out.println(wList.toString());
        json.element("wList",wList);
        return json.toString();
    }

   /* @RequestMapping("AllWeekly")
    public ModelAndView getAll(@RequestParam(value = "pageNum",defaultValue = "1")int pageNum, String method, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        //根据老师查询所教班级
        List<Classes> classList = scoreService.getClassByTid(user.getId());//班级列表
        modelAndView.addObject("classList",classList);

        Classes classes = (Classes)session.getAttribute("classes");
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

*/
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
            session.setAttribute("oldPassword",newPassword1);
            password = MD5Utils.getMD5Str(newPassword1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        staffService.updatePassword(user.getId(),password);
        modelAndView.setViewName("staff");
        return modelAndView;
    }

    //学生成绩走势图
    @RequestMapping("StudentScore")
    public ModelAndView studentScore(Integer sid){
        ModelAndView modelAndView = new ModelAndView();
        List<Score> scores = new ArrayList<>();
        Score score = new Score();
        score.setId(sid);
        List<Integer> scoreList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            ScoreVO scoreVO = scoreMapper.getScoreBySid(sid, i);//学生，i阶段成绩
            int stuScore = 0;
            if(scoreVO != null){
                stuScore = scoreVO.getScore();
            }
            scoreList.add(stuScore);
        }
        score.setScoreList(scoreList);//成绩列表
        scores.add(score);
        System.out.println("scoreList:" + scoreList.toString());
        modelAndView.addObject("scoreList",scoreList);
        modelAndView.setViewName("student_score");
        return modelAndView;
    }

}

