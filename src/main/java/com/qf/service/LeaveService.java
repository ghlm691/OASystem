package com.qf.service;

import com.qf.pojo.Leave;

import java.io.PrintWriter;
import java.util.List;

public interface LeaveService {

    //员工添加假条
    int addLeave(Leave leave);

    //显示待审批假条
    List<Leave> queryLeaveList(String name);

    //教师班主任审批假条
    int updateLeave(Integer lid);

    //realm相关
    String getPasswordByUname(String uname);

}
