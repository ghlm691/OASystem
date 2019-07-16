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

}
