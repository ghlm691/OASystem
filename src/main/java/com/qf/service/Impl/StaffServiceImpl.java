package com.qf.service.Impl;

import com.qf.mapper.StaffMapper;
import com.qf.pojo.Leave;
import com.qf.pojo.Weekly;
import com.qf.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:jerry
 * date:2019/7/15 20:32
 * description:
 */
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    //展示所有周报
    public List<Weekly> queryAll() {
        return staffMapper.queryAll();
    }

    public List<Weekly> queryAlreadyMark() {
        return staffMapper.queryAlreadyMark();
    }

    public Weekly queryDetail(Integer wid) {
        return staffMapper.queryDetail(wid);
    }

    public int updateWscore(Integer wid,Integer wscore) {
        return staffMapper.updateWscore(wid,wscore);
    }

    @Override
    public List<Leave> queryLeaveList(String name) {



        return null;
    }

}
