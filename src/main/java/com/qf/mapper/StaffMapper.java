package com.qf.mapper;

import com.qf.pojo.Weekly;
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

}
