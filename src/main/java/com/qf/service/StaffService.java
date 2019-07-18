package com.qf.service;

import com.qf.pojo.Classes;
import com.qf.pojo.Leave;
import com.qf.pojo.Weekly;
import com.qf.pojo.vo.ScoreVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffService {

    //查看所有周报
    List<Weekly> queryAll(Integer cid);

    //查看已打分的周报
    List<Weekly> queryAlreadyMark(Integer cid);

    //查看周报明细
    Weekly queryDetail(Integer wid);

    //打分
    int updateWscore(Integer wid,Integer wscore);

    //获取需要审批的假条
    List<Leave> queryLeaveList(String name);

    //删除周报
    int deleteWeekly(Integer wid);

    //查询老师所属班级
    Classes queryClassById(Integer uid);

    //修改密码
    int updatePassword(@Param("uid") Integer uid, @Param("password") String password);

    //添加学生成绩
    int addStuScore(ScoreVO scoreVO);

}
