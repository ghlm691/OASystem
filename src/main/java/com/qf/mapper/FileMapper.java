package com.qf.mapper;

import com.qf.pojo.Student;
import com.qf.pojo.UserVVo;
import com.qf.pojo.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileMapper {

    //查询所有班级
    List<Integer> getAllClassesId();

    //查询所有学生
    List<Student> getAllStudent();

    //批量添加学生
    int addStudent(UserVVo userVo);
    int queryCidByCname(String cname);
    int addStuClass(@Param("uid") Integer uid, @Param("cid") Integer cid);
    int addUserRole(@Param("uid") Integer uid, @Param("rid") Integer rid);
    int queryRid(String rname);


}
