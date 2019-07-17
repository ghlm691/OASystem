package com.qf.pojo.vo;

/**
 * author:赖文熙
 * date:2019/7/16 22:56
 * description:成绩数据库表
 */


public class ScoreVO {

    private int id;//成绩ID
    private int uid;//学生ID
    private int cid;//班级ID
    private int stage;//阶段ID
    private int score;//成绩

    public ScoreVO() {
    }

    public ScoreVO(int id, int uid, int cid, int stage, int score) {
        this.id = id;
        this.uid = uid;
        this.cid = cid;
        this.stage = stage;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ScoreVO{" +
                "id=" + id +
                ", uid=" + uid +
                ", cid=" + cid +
                ", stage=" + stage +
                ", score=" + score +
                '}';
    }
}
