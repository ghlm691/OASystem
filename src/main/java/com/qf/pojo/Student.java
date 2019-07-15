package com.qf.pojo;

/**
 * author:赖文熙
 * date:2019/7/15 15:12
 * description:学生信息表
 */


public class Student {

    private int sid;//学生ID
    private String username;//账号
    private String password;//密码
    private String sname;//学生姓名
    private String age;//年龄
    private String sex;//性别

    public Student() {
    }

    public Student(int sid, String username, String password, String sname, String age, String sex) {
        this.sid = sid;
        this.username = username;
        this.password = password;
        this.sname = sname;
        this.age = age;
        this.sex = sex;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sname='" + sname + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
