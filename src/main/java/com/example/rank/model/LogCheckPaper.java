package com.example.rank.model;

import java.util.Date;

public class LogCheckPaper {
    private Long id;

    private Long paperid;

    private Long checkuserid;

    private String firststate;

    private String updatedstate;

    private Date createdtime;
    private String paperName;
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaperid() {
        return paperid;
    }

    public void setPaperid(Long paperid) {
        this.paperid = paperid;
    }

    public Long getCheckuserid() {
        return checkuserid;
    }

    public void setCheckuserid(Long checkuserid) {
        this.checkuserid = checkuserid;
    }

    public String getFirststate() {
        return firststate;
    }

    public void setFirststate(String firststate) {
        this.firststate = firststate;
    }

    public String getUpdatedstate() {
        return updatedstate;
    }

    public void setUpdatedstate(String updatedstate) {
        this.updatedstate = updatedstate;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }
}