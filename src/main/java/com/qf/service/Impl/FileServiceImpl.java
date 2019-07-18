package com.qf.service.Impl;

import com.qf.mapper.FileMapper;
import com.qf.mapper.LeaveMapper;
import com.qf.mapper.ScoreMapper;
import com.qf.pojo.Classes;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.service.AdminService;
import com.qf.service.FileService;
import com.qf.service.ScoreService;
import com.qf.service.StudentService;
import com.qf.utils.ExcelUtils;
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
}
