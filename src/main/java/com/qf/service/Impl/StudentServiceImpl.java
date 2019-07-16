package com.qf.service.Impl;

import com.qf.mapper.AdminMapper;
import com.qf.mapper.StudentMapper;
import com.qf.pojo.Leave;
import com.qf.pojo.Student;
import com.qf.pojo.Weekly;
import com.qf.pojo.vo.UserVO;
import com.qf.pojo.vo.WeeklyVO;
import com.qf.service.StudentService;
import com.qf.utils.MD5Utils;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    //修改学生信息(除密码，姓名)
    public int updateStudent(Student student) {
        UserVO userVO = new UserVO();
        userVO.setUid(student.getSid());
        userVO.setUname(student.getUsername());
        userVO.setAge(student.getAge());
        userVO.setSex(student.getSex());
        return studentMapper.updateStudent(userVO);
    }

    @Override
    public void studentLeave(int sid) {

    }


    //新增周报
    public int addWeekly(WeeklyVO weeklyVO) {
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
            weekly.setWtitle(w.getWtitle());
            weekly.setWtime(w.getWtime());
            weekly.setWcontent(w.getWcontent());
            weekly.setWscore(w.getWscore());
            weekly.setStageName(studentMapper.getStage(w.getStage()));
            weeklyList.add(weekly);
        }
        return weeklyList;
    }

    //学生登录后获取资料
    public Student getStudentByUnamePwd(String username, String password) {
        System.out.println(username);
        Student student = new Student();
        try {
            UserVO userVO = studentMapper.getStudentByUnamePwd(username, MD5Utils.getMD5Str(password));
            String cname = adminMapper.getCname(userVO.getUid());
            student.setSid(userVO.getUid());
            student.setUsername(userVO.getUname());
            student.setPassword(userVO.getPassword());
            student.setSname(userVO.getName());
            student.setAge(userVO.getAge());
            student.setSex(userVO.getSex());
            student.setCname(cname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public Student getStudentBySid(int sid) {
        Student student = new Student();
        UserVO userVO = studentMapper.getStudent(sid);
        String cname = adminMapper.getCname(sid);
        student.setCname(cname);
        student.setSid(userVO.getUid());
        student.setUsername(userVO.getUname());
        student.setSname(userVO.getName());
        student.setAge(userVO.getAge());
        student.setSex(userVO.getSex());
        return student;
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

    public int updatePassword(int sid, String password) {
        int i = 0;
        try {
            i = studentMapper.updatePassword(sid, MD5Utils.getMD5Str(password));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
