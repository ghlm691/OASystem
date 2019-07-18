package com.qf.service.Impl;

import com.qf.mapper.ScoreMapper;
import com.qf.pojo.Classes;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.service.AdminService;
import com.qf.service.FileService;
import com.qf.service.ScoreService;
import com.qf.service.StudentService;
import com.qf.utils.ExcelUtils;
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

    @Override
    public int uploadFile(MultipartFile file, String path) {

        return 0;
    }

    //导出
    @Override
    public void exportFile(User user, OutputStream outputStream) {

        List<Integer> classes = scoreMapper.getClassByTid(user.getId());

        List<Student> students = new ArrayList<>();

        for (Integer aClass : classes) {

            List<Integer> sidByCid = scoreMapper.getSidByCid(aClass);

            for (Integer stuId : sidByCid) {

                Student student = studentService.getStudentBySid(stuId);

                students.add(student);

            }

        }

        try {
            ExcelUtils.export(outputStream, students);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
