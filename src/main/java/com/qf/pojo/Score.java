package com.qf.pojo;

import java.util.List;

/**
 * author:赖文熙
 * date:2019/7/16 22:58
 * description:成绩表
 */


public class Score {

    private int id;//学生ID
    private String name;//学生姓名
    private String cname;//班级名
    private List<Integer> scoreList;//各阶段成绩

    public Score() {
    }

    public Score(int id, String name, String cname, List<Integer> scoreList) {
        this.id = id;
        this.name = name;
        this.cname = cname;
        this.scoreList = scoreList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Integer> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Integer> scoreList) {
        this.scoreList = scoreList;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cname='" + cname + '\'' +
                ", scoreList=" + scoreList +
                '}';
    }
}
