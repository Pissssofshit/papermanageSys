package com.example.rank.dao;

import com.example.rank.model.PaperType;

public interface PaperTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PaperType record);

    int insertSelective(PaperType record);

    PaperType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PaperType record);

    int updateByPrimaryKey(PaperType record);
}