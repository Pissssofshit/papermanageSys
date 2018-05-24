package com.example.rank.dao;

import com.example.rank.model.logCheckPaper;

public interface logCheckPaperMapper {
    int deleteByPrimaryKey(Long id);

    int insert(logCheckPaper record);

    int insertSelective(logCheckPaper record);

    logCheckPaper selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(logCheckPaper record);

    int updateByPrimaryKey(logCheckPaper record);
}