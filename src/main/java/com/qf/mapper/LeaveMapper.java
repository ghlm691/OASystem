package com.qf.mapper;

        import com.qf.pojo.Leave;

        import java.util.List;

public interface LeaveMapper {

    //显示本人待审批的假条
    List<Leave> queryLeaveList(List<String> ids);

    //审批假条
    int updateLeave(Integer lid);

    //员工请假
    int addLeave(Leave leave);

    //就一个校长
    String queryBoss();

    //--------realm功能-------------
    String getPasswordByUname(String uname);

    //根据用户名查询数据库中的角色账户表，获取到该账户对应的角色列表
    List<String> getRoleList(String uname);

    //根据角色列表查询数据库中对应的权限名
    List<String> getPermissionList(String rname);

}
