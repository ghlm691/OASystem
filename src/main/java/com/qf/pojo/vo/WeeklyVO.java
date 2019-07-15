package com.qf.pojo.vo;

/**
 * author:赖文熙
 * date:2019/7/15 15:27
 * description:周报数据库表
 */


public class WeeklyVO {

    private int wid;//周报ID
    private int uid;//作者ID
    private String wtitle;//标题
    private String wtime;//发布时间
    private String wcontent;//内容
    private int wscore;//成绩

    public WeeklyVO() {
    }

    public WeeklyVO(int wid, int uid, String wtitle, String wtime, String wcontent, int wscore) {
        this.wid = wid;
        this.uid = uid;
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public int getWscore() {
        return wscore;
    }

    public void setWscore(int wscore) {
        this.wscore = wscore;
    }

    @Override
    public String toString() {
        return "WeeklyVO{" +
                "wid=" + wid +
                ", uid=" + uid +
                ", wtitle='" + wtitle + '\'' +
                ", wtime='" + wtime + '\'' +
                ", wcontent='" + wcontent + '\'' +
                ", wscore=" + wscore +
                '}';
    }
}
