package com.qf.mapper;

import com.qf.pojo.Classes;
import com.qf.pojo.vo.ScoreVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreMapper {

    //根据教师id查询班级
    List<Integer> getClassByTid(int uid);

    //根据班级id查询学生id
    List<Integer> getSidByCid(int cid);

    //根据学生id和阶段id查询各阶段成绩
    ScoreVO getScoreBySid(@Param(value = "uid") int sid, @Param(value = "stage") int stage);

    //根据id查询班级
    Classes getClasses(int cid);



}
