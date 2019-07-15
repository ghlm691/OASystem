package com.qf.mapper;

import com.qf.pojo.Student;
import com.qf.pojo.vo.StudentVO;

public interface StudentMapper {

    //修改信息
    int updateStudent(StudentVO studentVO);

    //查询学生
    Student getStudent(int uid);

}
