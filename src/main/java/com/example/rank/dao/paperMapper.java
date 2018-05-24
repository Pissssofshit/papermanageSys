package com.example.rank.dao;

import com.example.rank.model.paper;

public interface paperMapper {
    int deleteByPrimaryKey(Long id);

    int insert(paper record);

    int insertSelective(paper record);

    paper selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(paper record);

    int updateByPrimaryKeyWithBLOBs(paper record);

    int updateByPrimaryKey(paper record);
}