package com.qf.service;

import com.qf.pojo.Leave;
import com.qf.pojo.Weekly;

import java.util.List;

public interface StaffService {

    //查看所有周报
    List<Weekly> queryAll();

    //查看已打分的周报
    List<Weekly> queryAlreadyMark();

    //查看周报明细
    Weekly queryDetail(Integer wid);

    //打分
    int updateWscore(Integer wid,Integer wscore);

    //获取需要审批的假条
    List<Leave> queryLeaveList(String name);

    //删除周报
    int deleteWeekly(Integer wid);


}
