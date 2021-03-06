package com.qf.mapper;

import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.pojo.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {

    //增加课程
    int addCourse(CourseVO courseVO);

    //判断是否有课程
    CourseVO isNullCourse(String courseName);

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

    //删除账号
    int delUser(int uid);

    //删除账号相关周报
    int delWeekly(int uid);

    //查询讲师
    List<UserVO> getTeacher();

    //用户列表
    List<UserVO> getUser();

    //查询角色
    String getRoleName(int uid);

    //删除老师课程表
    int delCourseByUid(int uid);

    //删除成绩
    int delScore(int uid);

    //删除学生班级表
    int delUserClass(int uid);

    //重置密码
    int setPassword(@Param(value = "uid") int uid,@Param(value = "password") String password);

    //查看讲师是否有课程
    CourseVO checkTeacher(int uid);

    //判断是否有学生学该课程
    List<Integer> isNullClass(int cid);

    //给用户配置讲师角色
    int addTeacher(int uid);

    UserVO getTidByName(String name);

    List<RoleVO> getRole();

    int addRole(String rname);

    RoleVO checkRole(String rname);

    int delRole(int rid);

    List<ClassesVO> getClasses();

    String getTnameByCid(int cid);

    String getCourseByCid(int cid);

    int delClass(int cid);
    int delClassCourse(int cid);

    List<PermissionVO> getPermission(int uid);

    int delPermission(int pid);

    int delPermissionRole(int pid);

    PermissionVO checkPermission(String pname);

    int addPermission(String pname);

    PermissionVO getPermissionByPname(String pname);

    List<CourseVO> getCourse();

    int addClass(String cName);

    ClassesVO getClassByName(String name);

    int addClassCourse(@Param(value = "cid") int cid,@Param(value = "courseid") int courseid);
}
