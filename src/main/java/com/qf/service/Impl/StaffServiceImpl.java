package com.qf.service.Impl;

import com.qf.mapper.StaffMapper;
import com.qf.pojo.Classes;
import com.qf.pojo.Leave;
import com.qf.pojo.Weekly;
import com.qf.pojo.vo.ScoreVO;
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
    public List<Weekly> queryAll(Integer cid) {
        return staffMapper.queryAll(cid);
    }

    public List<Weekly> queryAlreadyMark(Integer cid) {
        return staffMapper.queryAlreadyMark(cid);
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

    @Override
    public int deleteWeekly(Integer wid) {
        return staffMapper.deleteWeekly(wid);
    }

    @Override
    public Classes queryClassById(Integer uid) {
        return staffMapper.queryClassById(uid);
    }

    @Override
    public int updatePassword(Integer uid, String password) {
        return staffMapper.updatePassword(uid,password);
    }

    @Override
    public int addStuScore(ScoreVO scoreVO) {
        return staffMapper.addStuScore(scoreVO);
    }

}
