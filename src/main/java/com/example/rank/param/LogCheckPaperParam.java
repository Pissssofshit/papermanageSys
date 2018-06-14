package com.example.rank.param;

import java.util.Date;

public class LogCheckPaperParam {
    private Long id;
    private int pageSize;
    private int pageStart;

    private Long paperId;

    private Long checkUserid;

    private String updatedState;

    private Date createdtime;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public Long getCheckUserid() {
        return checkUserid;
    }

    public void setCheckUserid(Long checkUserid) {
        this.checkUserid = checkUserid;
    }

    public String getUpdatedState() {
        return updatedState;
    }

    public void setUpdatedState(String updatedState) {
        this.updatedState = updatedState;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }
}
