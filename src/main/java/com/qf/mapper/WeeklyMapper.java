package com.qf.mapper;

import com.qf.pojo.vo.WeeklyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WeeklyMapper {

    //新增周报
    int addWeekly(WeeklyVO weeklyVO);

    //删除周报(已打分无法删除)
    int delWeekly(int wid);

    //展示周报
    List<WeeklyVO> queryWeeklyForStudent(int sid);

    //周报打分
    int addScore(@Param(value = "wid") int wid,@Param(value = "wscore") int score);

}
