package com.qf.service.Impl;

import com.qf.mapper.AdminMapper;
import com.qf.mapper.ScoreMapper;
import com.qf.mapper.StudentMapper;
import com.qf.pojo.Classes;
import com.qf.pojo.Score;
import com.qf.pojo.vo.ScoreVO;
import com.qf.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author:赖文熙
 * date:2019/7/17 11:03
 * description:
 */

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private AdminMapper adminMapper;

    //根据教师id查询班级
    @Override
    public List<Classes> getClassByTid(int uid) {
        List<Integer> cid = scoreMapper.getClassByTid(uid);
        List<Classes> classList = new ArrayList<>();
        for (Integer c:cid){
            Classes classes = scoreMapper.getClasses(c);
            classList.add(classes);
        }
        return classList;
    }

    //根据班级id查询学生成绩
    @Override
    public List<Score> getScoreByCid(int cid) {
        List<Score> scores = new ArrayList<>();
        List<Integer> sid = scoreMapper.getSidByCid(cid);
        for (Integer s:sid){
            Score score = new Score();
            score.setId(s);//学生id
            score.setName(studentMapper.getStudent(s).getName());//姓名
            score.setCname(adminMapper.getCname(s));//班级
            List<Integer> scoreList = new ArrayList<>();
            for (int i = 1; i < 5; i++) {
                ScoreVO scoreVO = scoreMapper.getScoreBySid(s, i);//学生，i阶段成绩
                int stuScore = 0;
                if(scoreVO != null){
                    stuScore = scoreVO.getScore();
                }
                scoreList.add(stuScore);
            }
            score.setScoreList(scoreList);//成绩列表
            scores.add(score);
            System.out.println("scoreList:" + scoreList.toString());
        }
        System.out.println("scores:" + scores.toString());
        return scores;
    }
}
