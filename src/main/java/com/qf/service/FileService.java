package com.qf.service;

import com.qf.pojo.Student;
import com.qf.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.util.List;

/**
 * author: liu
 * date: 2019/7/17 23:52
 * info :
 */
public interface FileService {

   //文件上传
    int uploadFile(MultipartFile file, String path);

    //信息导出
    void exportFile(User user, OutputStream outputStream);

    //查询user对应的班级
    List<Student> getStudentsById(User user);



}
