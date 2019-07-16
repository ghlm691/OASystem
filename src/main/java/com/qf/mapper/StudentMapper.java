package com.qf.mapper;

import com.qf.pojo.Student;
import com.qf.pojo.vo.UserVO;
import com.qf.pojo.vo.WeeklyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    //修改信息
    int updateStudent(UserVO userVO);

    //查询学生
    UserVO getStudent(int uid);

    //新增周报
    int addWeekly(WeeklyVO weeklyVO);

    //删除周报(已打分无法删除)
    int delWeekly(int wid);

    //展示周报
    List<WeeklyVO> queryWeeklyForStudent(int sid);

    UserVO getStudentByUnamePwd(@Param(value = "uname") String uname,@Param(value = "password") String password);

}
