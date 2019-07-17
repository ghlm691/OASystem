package com.qf.controller;

import com.qf.pojo.Classes;
import com.qf.pojo.Score;
import com.qf.pojo.User;
import com.qf.service.ScoreService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * author:赖文熙
 * date:2019/7/16 23:23
 * description:成绩
 */

@Controller
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    //跳转成绩管理页面
    @RequestMapping("toScore")
    public ModelAndView scorePage(int uid){
        ModelAndView modelAndView = new ModelAndView();
        //根据老师查询所教班级
        List<Classes> classList = scoreService.getClassByTid(uid);//班级列表
        modelAndView.addObject("classList",classList);
        //展示第一个班级学生成绩
        List<Score> score = scoreService.getScoreByCid(classList.get(0).getCid());
        modelAndView.addObject("score",score);
        modelAndView.setViewName("score");
        return modelAndView;
    }

    //更新成绩展示
    @RequestMapping(value = "changeScore",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String changeScore(int cid){
        JSONObject json = new JSONObject();
        //展示所选班级
        List<Score> score = scoreService.getScoreByCid(cid);
        json.element("sList",score);
        return json.toString();
    }


}
