package com.qf.service.Impl;

import com.qf.mapper.FileMapper;
import com.qf.mapper.LeaveMapper;
import com.qf.mapper.ScoreMapper;
import com.qf.pojo.Classes;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.pojo.UserVVo;
import com.qf.pojo.vo.UserVO;
import com.qf.service.AdminService;
import com.qf.service.FileService;
import com.qf.service.ScoreService;
import com.qf.service.StudentService;
import com.qf.utils.ExcelUtils;
import com.qf.utils.HanyuPinyinHelp;
import com.qf.utils.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * author: liu
 * date: 2019/7/17 23:53
 * info :
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private ScoreService scoreService;
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private StudentService studentService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private LeaveMapper leaveMapper;


    @Override
    public int uploadFile(MultipartFile file, String path) {

        return 0;
    }

    //导出
    @Override
    public void exportFile(User user, OutputStream outputStream) {

        List<Student> students = getStudentsById(user);

        try {
            ExcelUtils.export(outputStream, students);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Student> getStudentsById(User user) {

        List<String> roleList = leaveMapper.getRoleList(user.getUsername());
        List<Integer> sids = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        for (String s : roleList) {
            if (s.equals("teacher")){
                List<Integer> classes = scoreMapper.getClassByTid(user.getId());
                for (Integer aClass : classes) {
                    sids = scoreMapper.getSidByCid(aClass);
                    for (Integer sid : sids) {
                        Student student = studentService.getStudentBySid(sid);
                        students.add(student);
                    }
                }

            }else if(s.equals("leader")) {
                students = fileMapper.getAllStudent();
            }
        }


        return students;
    }

    @Override
    public int addStudents(List<Student> students) {

        for (Student student : students) {

            //UserVO userVO = new UserVO();

            String username = HanyuPinyinHelp.toHanyuPinyin(student.getSname());
            String password = null;
            try {
                password = MD5Utils.getMD5Str("123");
            } catch (Exception e) {
                e.printStackTrace();
            }

            student.setUsername(username);
            student.setPassword(password);

            UserVVo userVo = new UserVVo();
            userVo.setUname(student.getUsername());
            userVo.setPassword(student.getPassword());
            userVo.setName(student.getSname());
            String age = student.getAge().substring(0, 1);
            userVo.setAge(age);
            String sex = student.getSex().substring(0, 1);
            userVo.setSex(Integer.parseInt(sex));

            int i = fileMapper.queryCidByCname(student.getCname());
            fileMapper.addStudent(userVo);
            fileMapper.addStuClass(userVo.getUid(),i);
            int rid = fileMapper.queryRid("student");
            fileMapper.addUserRole(student.getSid(), rid);



        }

        return 0;
    }
}
