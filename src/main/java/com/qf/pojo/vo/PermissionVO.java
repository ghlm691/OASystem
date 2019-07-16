package com.qf.pojo.vo;

/**
 * author:赖文熙
 * date:2019/7/15 23:04
 * description:
 */


public class PermissionVO {

    private int pid;//权限ID
    private String pname;//权限

    public PermissionVO() {
    }

    public PermissionVO(int pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "PermissionVO{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                '}';
    }
}
