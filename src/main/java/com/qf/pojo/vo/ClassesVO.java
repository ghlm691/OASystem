package com.qf.pojo.vo;

/**
 * author:赖文熙
 * date:2019/7/15 19:21
 * description:班级
 */


public class ClassesVO {

    private int cid;//班级ID
    private String cname;//班级名

    public ClassesVO() {
    }

    public ClassesVO(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
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

    @Override
    public String toString() {
        return "Classes{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
