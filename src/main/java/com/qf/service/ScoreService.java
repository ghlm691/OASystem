package com.qf.service;

import com.qf.pojo.Classes;
import com.qf.pojo.Score;

import java.util.List;

public interface ScoreService {

    //根据教师查询班级
    List<Classes> getClassByTid(Integer uid);

    //根据班级查询学生成绩
    List<Score> getScoreByCid(Integer cid);



}
