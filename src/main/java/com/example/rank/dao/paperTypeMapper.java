package com.example.rank.dao;

import com.example.rank.model.paperType;

public interface paperTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(paperType record);

    int insertSelective(paperType record);

    paperType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(paperType record);

    int updateByPrimaryKey(paperType record);
}