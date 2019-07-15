package com.qf.pojo.vo;

/**
 * author:赖文熙
 * date:2019/7/15 19:35
 * description:课程数据库表
 */


public class CourseVO {

    private int courseId;//课程ID
    private String courseName;
    private int uid;//教师ID

    public CourseVO() {
    }

    public CourseVO(int courseId, String courseName, int uid) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.uid = uid;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "CourseVO{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", uid=" + uid +
                '}';
    }
}
