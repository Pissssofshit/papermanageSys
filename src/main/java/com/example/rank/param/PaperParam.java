package com.example.rank.param;

import java.util.Date;

public class PaperParam {
    private Long id;

    private String title;

    private Date createdtimeOne;

    private Date createdtimeTwo;

    private Date updatedtimeOne;

    private Date updatedtimeTwo;

    private Long userid;

    private Integer readNum;

    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedtimeOne() {
        return createdtimeOne;
    }

    public void setCreatedtimeOne(Date createdtimeOne) {
        this.createdtimeOne = createdtimeOne;
    }

    public Date getCreatedtimeTwo() {
        return createdtimeTwo;
    }

    public void setCreatedtimeTwo(Date createdtimeTwo) {
        this.createdtimeTwo = createdtimeTwo;
    }

    public Date getUpdatedtimeOne() {
        return updatedtimeOne;
    }

    public void setUpdatedtimeOne(Date updatedtimeOne) {
        this.updatedtimeOne = updatedtimeOne;
    }

    public Date getUpdatedtimeTwo() {
        return updatedtimeTwo;
    }

    public void setUpdatedtimeTwo(Date updatedtimeTwo) {
        this.updatedtimeTwo = updatedtimeTwo;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
