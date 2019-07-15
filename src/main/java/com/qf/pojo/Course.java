package com.qf.pojo;

/**
 * author:赖文熙
 * date:2019/7/15 19:33
 * description:课程
 */


public class Course {

    private int id;//课程ID
    private String courseName;//课程名
    private String tname;//教师名

    public Course() {
    }

    public Course(int id, String courseName, String tname) {
        this.id = id;
        this.courseName = courseName;
        this.tname = tname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", tname='" + tname + '\'' +
                '}';
    }
}
