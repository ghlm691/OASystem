package com.qf.service;

import com.qf.pojo.Student;
import com.qf.pojo.Weekly;

import java.util.List;

public interface StudentService {

    //修改信息
    int updateStudent(Student student);

    //学生请假
    void studentLeave(int sid);

    //新增周报
    int addWeekly(Weekly weekly,int uid);

    //删除周报(已打分无法删除)
    int delWeekly(int wid);

    //展示周报
    List<Weekly> queryWeeklyForStudent(int sid);

    //学生登录
    Student getStudentByUnamePwd(String username,String password);

    //查询学生
    Student getStudentBySid(int sid);

}
