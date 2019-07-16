package com.qf.pojo;

import com.qf.pojo.vo.PermissionVO;

import java.util.List;

/**
 * author:赖文熙
 * date:2019/7/15 23:07
 * description:角色表
 */


public class Role {

    private int rid;//角色ID
    private String rname;//角色名
    private List<PermissionVO> pList;//权限集

    public Role() {
    }

    public Role(int rid, String rname, List<PermissionVO> pList) {
        this.rid = rid;
        this.rname = rname;
        this.pList = pList;
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

    public List<PermissionVO> getpList() {
        return pList;
    }

    public void setpList(List<PermissionVO> pList) {
        this.pList = pList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", pList=" + pList +
                '}';
    }
}
