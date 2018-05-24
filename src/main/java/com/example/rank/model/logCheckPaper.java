package com.example.rank.model;

public class logCheckPaper {
    private Long id;

    private Long paperid;

    private Long checkuserid;

    private String firststate;

    private String updatedstate;

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
}