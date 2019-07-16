package com.qf.service.Impl;

import com.qf.mapper.StudentMapper;
import com.qf.mapper.WeeklyMapper;
import com.qf.pojo.Leave;
import com.qf.pojo.Student;
import com.qf.pojo.Weekly;
import com.qf.pojo.vo.UserVO;
import com.qf.pojo.vo.WeeklyVO;
import com.qf.service.StudentService;
import com.qf.utils.MD5Utils;
import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author:赖文熙
 * date:2019/7/15 15:38
 * description:
 */

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private WeeklyMapper weeklyMapper;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

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



    //新增周报
    public int addWeekly(Weekly weekly,int uid) {
        WeeklyVO weeklyVO = new WeeklyVO();
        weeklyVO.setWid(weekly.getWid());
        weeklyVO.setUid(uid);
        weeklyVO.setWtitle(weekly.getWtitle());
        weeklyVO.setWtime(weekly.getWtime());
        weeklyVO.setWcontent(weekly.getWcontent());
        return weeklyMapper.addWeekly(weeklyVO);
    }

    //删除周报
    public int delWeekly(int wid) {
        return weeklyMapper.delWeekly(wid);
    }

    //查询周报
    public List<Weekly> queryWeeklyForStudent(int sid) {
        List<WeeklyVO> weeklyVOList = weeklyMapper.queryWeeklyForStudent(sid);
        List<Weekly> weeklyList = new ArrayList<Weekly>();
        for (WeeklyVO w : weeklyVOList){
            Weekly weekly = new Weekly();
            weekly.setWid(w.getWid());
            weekly.setUname(studentMapper.getStudent(w.getUid()).getUname());
            weekly.setWtitle(w.getWtitle());
            weekly.setWtime(w.getWtime());
            weekly.setWcontent(w.getWcontent());
            weekly.setWscore(w.getWscore());
            weeklyList.add(weekly);
        }
        return weeklyList;
    }

    @Override
    public int addStudentLeave(Leave leave) {

        int i = studentMapper.addLeave(leave);
        long starttime = leave.getStartdate().getTime();
        long endtime = leave.getEnddate().getTime();

        long l = starttime - endtime;

        Date day = new Date(l);

        Map<String, Object> map = new HashMap<>();
        map.put("role", "student");
        map.put("student", leave.getUser().getUsername());
        map.put("teacher", studentMapper.queryTeacher(studentMapper.queryClass(leave.getUser().getId())));
        map.put("leader", studentMapper.queryLeader(studentMapper.queryClass(leave.getUser().getId())));
        map.put("boss", studentMapper.queryBoss());
        map.put("day", day);

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leave", leave.getLid() + "", map);

        Task task = taskService.createTaskQuery().taskAssignee(leave.getUser().getUsername()).singleResult();

        taskService.complete(task.getId());

        return i;
    }
}
