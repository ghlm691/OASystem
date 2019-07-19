package com.qf.service;

import com.qf.pojo.Leave;
import com.qf.pojo.Student;
import com.qf.pojo.User;

import java.util.List;

public interface LeaveService {

    //员工添加假条
    int addLeave(Leave leave);

    //显示待审批假条
    List<Leave> queryLeaveList(String name);

    //教师班主任审批假条
    int updateLeave(Integer lid, String name);

    //realm相关
    String getPasswordByUname(String uname);

    //根据用户名查询数据库中的角色账户表，获取到该账户对应的角色列表
    List<String> getRoleList(String uname);

    //获取角色名对应的权限列表
    List<String> getPermissionList(String rname);

    //获取请假情况
    List isApproved(User user);

}
