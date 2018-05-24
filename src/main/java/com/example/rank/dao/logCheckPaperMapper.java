package com.example.rank.dao;

import com.example.rank.model.LogCheckPaper;

public interface LogCheckPaperMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LogCheckPaper record);

    int insertSelective(LogCheckPaper record);

    LogCheckPaper selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LogCheckPaper record);

    int updateByPrimaryKey(LogCheckPaper record);
}