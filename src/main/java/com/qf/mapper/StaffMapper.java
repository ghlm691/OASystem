package com.qf.mapper;

import com.qf.pojo.Weekly;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * author:jerry
 * date:2019/7/15 20:22
 * description:
 */
@Controller
public interface StaffMapper {

    //查看所有周报
    List<Weekly> queryAll();

    //查看已打分的周报
    List<Weekly> queryAlreadyMark();

    //查看周报明细
    Weekly queryDetail(Integer wid);

    //打分
    int updateWscore(@Param(value = "wid") Integer wid,@Param("wscore") Integer wscore);

    //删除周报
    int deleteWeekly(Integer wid);


}
