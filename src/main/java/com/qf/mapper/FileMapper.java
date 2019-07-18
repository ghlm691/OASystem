package com.qf.mapper;

import com.qf.pojo.Student;

import java.util.List;

public interface FileMapper {

    //查询所有班级
    List<Integer> getAllClassesId();

    //查询所有学生
    List<Student> getAllStudent();


}
