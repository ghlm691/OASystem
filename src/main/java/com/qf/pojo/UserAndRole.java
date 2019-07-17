package com.qf.pojo;

/**
 * author:赖文熙
 * date:2019/7/17 20:49
 * description:用户加角色
 */


public class UserAndRole {

    private int id;//用户ID
    private String username;//帐号
    private String password;//密码
    private String name;//姓名
    private String rname;//角色名

    public UserAndRole() {
    }

    public UserAndRole(int id, String username, String password, String name, String rname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.rname = rname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    @Override
    public String toString() {
        return "UserAndRole{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", rname='" + rname + '\'' +
                '}';
    }
}
