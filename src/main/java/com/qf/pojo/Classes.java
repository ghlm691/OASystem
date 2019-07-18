package com.qf.pojo;

/**
 * author:赖文熙
 * date:2019/7/15 19:21
 * description:班级
 */


public class Classes {

    private int cid;//班级ID
    private String cname;//班级名
    private String course;//课程
    private String tname;//老师

    public Classes() {
    }

    public Classes(int cid, String cname, String course, String tname) {
        this.cid = cid;
        this.cname = cname;
        this.course = course;
        this.tname = tname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", course='" + course + '\'' +
                ", tname='" + tname + '\'' +
                '}';
    }
}
