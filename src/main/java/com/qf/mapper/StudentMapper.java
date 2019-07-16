package com.qf.mapper;

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

    UserVO getStudentByUnamePwd(@Param(value = "uname") String username,@Param(value = "password") String password);

    //查询阶段
    String getStage(int stage);

    /*请假相关*/
    //添加请假信息
    int addLeave(Leave leave);

    //查询学生所在的班级
    Integer queryClass(Integer uid);

    //查询对应班级的教师
    String queryTeacher(Integer cid);

    //查询对应班级的班主任
    String queryLeader(Integer cid);

    //就一个校长
    String queryBoss();

    //修改密码
    int updatePassword(@Param(value = "uid") int uid,@Param(value = "password") String password);

}
