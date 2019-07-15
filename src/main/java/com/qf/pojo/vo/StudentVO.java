package com.qf.pojo.vo;

/**
 * author:赖文熙
 * date:2019/7/15 16:02
 * description:
 */


public class StudentVO {

    private int uid;//用户ID
    private String uname;//账号
    private String password;//密码
    private String name;//姓名
    private String age;//年龄
    private String sex;//性别

    public StudentVO() {
    }

    public StudentVO(int uid, String uname, String password, String name, String age, String sex) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "StudentVO{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
