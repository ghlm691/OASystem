package com.qf.service.Impl;

import com.qf.mapper.StudentMapper;
import com.qf.pojo.Student;
import com.qf.pojo.Weekly;
import com.qf.pojo.vo.UserVO;
import com.qf.pojo.vo.WeeklyVO;
import com.qf.service.StudentService;
import com.qf.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author:赖文熙
 * date:2019/7/15 15:38
 * description:
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    //修改学生信息
    public int updateStudent(Student student) {
        UserVO userVO = new UserVO();
        userVO.setUid(student.getSid());
        userVO.setUname(student.getUsername());
        try {
            userVO.setPassword(MD5Utils.getMD5Str(student.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        userVO.setName(student.getSname());
        userVO.setAge(student.getAge());
        userVO.setSex(student.getSex());
        return studentMapper.updateStudent(userVO);
    }

    //学生请假
    public void studentLeave(int sid) {

    }

    //新增周报
    public int addWeekly(Weekly weekly,int uid) {
        WeeklyVO weeklyVO = new WeeklyVO();
        weeklyVO.setWid(weekly.getWid());
        weeklyVO.setUid(uid);
        weeklyVO.setWtitle(weekly.getTitle());
        weeklyVO.setWtime(weekly.getTime());
        weeklyVO.setWcontent(weekly.getContent());
        return studentMapper.addWeekly(weeklyVO);
    }

    //删除周报
    public int delWeekly(int wid) {
        return studentMapper.delWeekly(wid);
    }

    //查询周报
    public List<Weekly> queryWeeklyForStudent(int sid) {
        List<WeeklyVO> weeklyVOList = studentMapper.queryWeeklyForStudent(sid);
        List<Weekly> weeklyList = new ArrayList<Weekly>();
        for (WeeklyVO w : weeklyVOList){
            Weekly weekly = new Weekly();
            weekly.setWid(w.getWid());
            weekly.setUname(studentMapper.getStudent(w.getUid()).getUname());
            weekly.setTitle(w.getWtitle());
            weekly.setTime(w.getWtime());
            weekly.setContent(w.getWcontent());
            weekly.setScore(w.getWscore());
            weeklyList.add(weekly);
        }
        return weeklyList;
    }
}
