package com.qf.mapper;

import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.pojo.vo.CourseVO;
import com.qf.pojo.vo.UserVO;

import java.util.List;

public interface AdminMapper {

    //增加课程
    int addCourse(CourseVO courseVO);

    //删除课程
    int delCourse(int cid);

    //查询课程列表
    List<CourseVO> queryCourse();

    //查询名字
    String queryName(int uid);

    //添加用户(账户名为名字小写全拼,密码为123456MD5加密,不可同名)
    int addUser(UserVO userVO);

    //查询是否同名
    UserVO checkUser(String name);

    //查询用户(除学生外)
    User getUserByName(String name);

    //查询学生
    Student getStudentByName(String name);

    //查询班级名
    String getCname(int uid);



}
