package com.qf.service;

import com.qf.pojo.Leave;
import com.qf.pojo.Student;
import com.qf.pojo.Weekly;
import com.qf.pojo.vo.WeeklyVO;

import java.util.List;

public interface StudentService {

    //修改信息
    int updateStudent(Student student);

    //学生请假
    void studentLeave(Integer sid);

    //新增周报
    int addWeekly(WeeklyVO weeklyVO);

    //删除周报(已打分无法删除)
    int delWeekly(Integer wid);

    //展示周报
    List<Weekly> queryWeeklyForStudent(Integer sid);

    //学生登录
    Student getStudentByUnamePwd(String username,String password);

    //查询学生
    Student getStudentBySid(Integer sid);

    /*请假*/
    //添加请假信息
    int addStudentLeave(Leave leave);

    //修改密码
    int updatePassword(Integer sid,String password);

}
