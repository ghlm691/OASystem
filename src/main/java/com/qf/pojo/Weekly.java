package com.qf.pojo;

/**
 * author:赖文熙
 * date:2019/7/15 15:22
 * description:周报
 */


public class Weekly {

    private int wid;//周报ID
    private String uname;//作者姓名
    private String title;//周报标题
    private String time;//周报发布时间
    private String content;//周报内容
    private int score;//周报分数

    public Weekly() {
    }

    public Weekly(int wid, String uname, String title, String time, String content, int score) {
        this.wid = wid;
        this.uname = uname;
        this.title = title;
        this.time = time;
        this.content = content;
        this.score = score;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Weekly{" +
                "wid=" + wid +
                ", uname=" + uname +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                ", score=" + score +
                '}';
    }
}
