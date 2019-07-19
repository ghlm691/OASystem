package com.qf.service;

import com.qf.pojo.*;
import com.qf.pojo.vo.CourseVO;
import com.qf.pojo.vo.PermissionVO;
import com.qf.pojo.vo.RoleVO;
import com.qf.pojo.vo.UserVO;

import java.util.List;

public interface AdminService {

    //增加课程
    int addCourse(CourseVO courseVO);

    //查询课程
    boolean isNullCourse(String courseName);

    //删除课程
    boolean delCourse(int cid);

    //查询课程列表
    List<Course> queryCourse();

    //添加用户(账户名为名字小写全拼,密码为123456MD5加密,不可同名)
    boolean addUser(String name);

    //查询用户(除学生外)
    User getUserByName(String name);

    //查询学生
    Student getStudentByName(String name);

    //查询教师
    List<UserVO> getTeacher();

    //用户列表
    List<UserAndRole> getUser();

    //删除用户
    boolean delUser(int uid);

    //重置密码
    int setPassword(int uid);

    //查看讲师是否有课程
    boolean checkTeacher(int tid);

    void addTeacher(int tid);

    UserVO getTidByName(String name);

    //查询角色
    List<RoleVO> getRole();

    boolean addRole(String roleName);

    int delRole(int rid);

    List<Classes> getClasses();

    boolean delClass(int cid);

    List<PermissionVO> getPermission(int uid);

    void delPermission(int pid);

    boolean addPermission(String pname);

    PermissionVO getPermissionByPname(String pname);

    List<CourseVO> getCourse();

    int addClass(String cName, int courseId);
}
