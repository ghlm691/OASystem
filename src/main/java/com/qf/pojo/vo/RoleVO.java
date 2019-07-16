package com.qf.pojo.vo;

/**
 * author:赖文熙
 * date:2019/7/15 23:07
 * description:
 */


public class RoleVO {

    private int rid;
    private String rname;//角色名

    public RoleVO() {
    }

    public RoleVO(int rid, String rname) {
        this.rid = rid;
        this.rname = rname;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    @Override
    public String toString() {
        return "RoleVO{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                '}';
    }
}
