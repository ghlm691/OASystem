package com.qf.service.Impl;

import com.qf.mapper.AdminMapper;
import com.qf.mapper.ScoreMapper;
import com.qf.pojo.*;
import com.qf.pojo.vo.*;
import com.qf.service.AdminService;
import com.qf.utils.HanyuPinyinHelp;
import com.qf.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author:赖文熙
 * date:2019/7/15 19:39
 * description:
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private ScoreMapper scoreMapper;


    public int addCourse(CourseVO courseVO) {
        int i = adminMapper.addCourse(courseVO);
        return i;
    }

    @Override
    public boolean isNullCourse(String courseName) {
        CourseVO courseVO = adminMapper.isNullCourse(courseName);
        if(courseVO != null){
            return false;//存在
        }
        return true;//不存在
    }

    public boolean delCourse(int cid) {
        //查询是否还有班级学习本课程
        List<Integer> list = adminMapper.isNullClass(cid);
        if(list.size() != 0){
            //无法删除
            return false;
        }
        adminMapper.delCourse(cid);
        return true;
    }

    public List<Course> queryCourse() {
        List<CourseVO> courseVOList = adminMapper.queryCourse();
        List<Course> courseList = new ArrayList<Course>();
        for (CourseVO c : courseVOList){
            Course course = new Course();
            course.setId(c.getCourseId());
            course.setCourseName(c.getCourseName());
            course.setTname(adminMapper.queryName(c.getUid()));
            courseList.add(course);
        }
        return courseList;
    }

    public boolean addUser(String name) {
        UserVO userVO = new UserVO();
        if(adminMapper.checkUser(name) != null){
            //存在同名
            return false;
        }
        userVO.setUname(HanyuPinyinHelp.getPinyinString(name));
        try {
            userVO.setPassword(MD5Utils.getMD5Str("123456"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        userVO.setName(name);
        adminMapper.addUser(userVO);
        return true;
    }

    public User getUserByName(String name) {
        User user = adminMapper.getUserByName(name);
        return user;
    }

    public Student getStudentByName(String name) {
        Student student = adminMapper.getStudentByName(name);
        String cname = adminMapper.getCname(student.getSid());
        student.setCname(cname);
        return student;
    }

    @Override
    public List<UserVO> getTeacher() {
        return adminMapper.getTeacher();
    }

    @Override
    public List<UserAndRole> getUser() {
        List<UserVO> userVOList = adminMapper.getUser();
        List<UserAndRole> users = new ArrayList<>();
        for (UserVO u:userVOList){
            UserAndRole user = new UserAndRole();
            user.setId(u.getUid());
            user.setUsername(u.getUname());
            user.setPassword(u.getPassword());
            user.setName(u.getName());
            String roleName = adminMapper.getRoleName(u.getUid());
            if (roleName == null){
                user.setRname("student");
            }else{
                user.setRname(roleName);
            }
            users.add(user);
        }
        return users;
    }

    @Override
    public boolean delUser(int uid) {
        //查询角色(超级管理员不可删除、有课程的讲师不可删除)
        String roleName = adminMapper.getRoleName(uid);
        //删除用户表
        if("admin".equals(roleName)){
            //管理员无法删除
            return false;
        }else if("boss".equals(roleName)){
            //校长不用想直接删
            adminMapper.delUser(uid);
        }else if("leader".equals(roleName)){
            //班主任不用想直接删
            adminMapper.delUser(uid);
        }else if("teacher".equals(roleName)){
            //判断是否还在上课
            List<Integer> classes = scoreMapper.getClassByTid(uid);
            if(classes.size() != 0){
                //该老师还有课程
                return false;
            }else{
                //直接删
                adminMapper.delUser(uid);
                //删除course表
                adminMapper.delCourseByUid(uid);
            }
        }else{
            //删除学生
            adminMapper.delUser(uid);
            //删除成绩
            adminMapper.delScore(uid);
            //删除周报
            adminMapper.delWeekly(uid);
            //删除学生班级表
            adminMapper.delUserClass(uid);
        }
        return true;
    }

    @Override
    public int setPassword(int uid) {
        int i = 0;
        try {
            i = adminMapper.setPassword(uid,MD5Utils.getMD5Str("123456"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public boolean checkTeacher(int tid) {
        CourseVO courseVO = adminMapper.checkTeacher(tid);
        if (courseVO != null){
            //已有课程
            return true;
        }
        return false;
    }

    @Override
    public void addTeacher(int tid) {
        adminMapper.addTeacher(tid);
    }

    public UserVO getTidByName(String name){
        return adminMapper.getTidByName(name);
    }

    @Override
    public List<RoleVO> getRole() {
        return adminMapper.getRole();
    }

    @Override
    public boolean addRole(String roleName) {
        RoleVO roleVO = adminMapper.checkRole(roleName);
        if (roleVO != null){
            return false;
        }
        adminMapper.addRole(roleName);
        return true;
    }

    @Override
    public int delRole(int rid) {
        return adminMapper.delRole(rid);
    }

    @Override
    public List<Classes> getClasses() {
        List<Classes> list = new ArrayList<>();
        List<ClassesVO> classes = adminMapper.getClasses();
        for(ClassesVO cVO : classes){
            Classes c = new Classes();
            c.setCid(cVO.getCid());
            c.setCname(cVO.getCname());
            c.setCourse(adminMapper.getCourseByCid(cVO.getCid()));
            c.setTname(adminMapper.getTnameByCid(cVO.getCid()));
            list.add(c);
        }
        return list;
    }

    @Override
    public boolean delClass(int cid) {
        List<Integer> sid = scoreMapper.getSidByCid(cid);
        if (sid.size() != 0){
            //有学生
            return false;
        }
        adminMapper.delClass(cid);
        adminMapper.delClassCourse(cid);
        return true;
    }

    public List<PermissionVO> getPermission(int uid){
        List<PermissionVO> pList = adminMapper.getPermission(uid);
        return pList;
    }

    @Override
    public void delPermission(int pid) {
        adminMapper.delPermission(pid);
        adminMapper.delPermissionRole(pid);
    }


}
