package com.qf.service.Impl;

import com.qf.mapper.AdminMapper;
import com.qf.pojo.Course;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.pojo.UserAndRole;
import com.qf.pojo.vo.CourseVO;
import com.qf.pojo.vo.UserVO;
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

    public int delCourse(int cid) {
        return adminMapper.delCourse(cid);
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
            user.setRname(adminMapper.getRoleName(u.getUid()));
            users.add(user);
        }
        return users;
    }


}
