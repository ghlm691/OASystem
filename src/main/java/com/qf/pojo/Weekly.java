package com.qf.pojo;

/**
 * author:赖文熙
 * date:2019/7/15 15:22
 * description:周报
 */


public class Weekly {


    private int wid;//周报ID
    private String uname;//作者姓名
    private String wtitle;//周报标题
    private String wtime;//周报发布时间
    private String wcontent;//周报内容
    private Integer wscore;//周报分数

    public Weekly() {
    }

    public Weekly(int wid, String uname, String wtitle, String wtime, String wcontent, int wscore) {
        this.wid = wid;
        this.uname = uname;
        this.wtitle = wtitle;
        this.wtime = wtime;
        this.wcontent = wcontent;
        this.wscore = wscore;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getWtitle() {
        return wtitle;
    }

    public void setWtitle(String wtitle) {
        this.wtitle = wtitle;
    }

    public String getWtime() {
        return wtime;
    }

    public void setWtime(String wtime) {
        this.wtime = wtime;
    }

    public String getWcontent() {
        return wcontent;
    }

    public void setWcontent(String wcontent) {
        this.wcontent = wcontent;
    }

    public Integer getWscore() {
        return wscore;
    }

    public void setWscore(Integer wscore) {
        this.wscore = wscore;
    }

    @Override
    public String toString() {
        return "Weekly{" +
                "wid=" + wid +
                ", uname='" + uname + '\'' +
                ", wtitle='" + wtitle + '\'' +
                ", wtime='" + wtime + '\'' +
                ", wcontent='" + wcontent + '\'' +
                ", wscore=" + wscore +
                '}';
    }
}
