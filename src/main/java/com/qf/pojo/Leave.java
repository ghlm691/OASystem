package com.qf.pojo;

import java.sql.Date;

/**
 * author: liu
 * date: 2019/7/15 19:36
 * info :
 */
public class Leave {

    private Integer lid;
    private Date startdate;
    private Date enddate;
    private String reason;
    private Integer state;
    private User user;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "lid=" + lid +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", reason='" + reason + '\'' +
                ", state=" + state +
                ", user=" + user +
                '}';
    }
}
