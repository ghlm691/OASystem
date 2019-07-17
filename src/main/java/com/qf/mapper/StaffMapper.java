package com.qf.mapper;

import com.qf.pojo.Classes;
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

    //查看本班所有周报
    List<Weekly> queryAll(Integer cid);

    //查看本班已打分的周报
    List<Weekly> queryAlreadyMark(Integer cid);

    //查看周报明细
    Weekly queryDetail(Integer wid);

    //打分
    int updateWscore(@Param("wid") Integer wid,@Param("wscore") Integer wscore);

    //删除周报
    int deleteWeekly(Integer wid);

    //修改密码
    int updatePassword(@Param("uid") Integer uid,@Param("password") String password);

    //查询老师所属班级
    Classes queryClassById(Integer uid);


}
