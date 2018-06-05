package com.example.rank.dao;

import com.example.rank.model.Paper;
import com.example.rank.param.AddPaperParam;

import com.example.rank.param.PaperParam;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface PaperMapper {
    void add(AddPaperParam param);
    List<Paper> getPapers();
    List<Paper> getPapersByCon(@Param("id")Long id,@Param("userId")Long userId, @Param("title")String title, @Param("state")String state, @Param("createTimeOne")Date createTimeOne, @Param("createTimeTwo")Date createTimeTwo, @Param("updatedTimeOne")Date updatedTimeOne, @Param("updatedTimeTwo")Date updatedTimeTwo);
}