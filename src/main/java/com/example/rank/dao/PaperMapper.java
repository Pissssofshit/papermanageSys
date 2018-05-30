package com.example.rank.dao;

import com.example.rank.model.Paper;
import com.example.rank.param.PaperParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Paper record);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKeyWithBLOBs(Paper record);

    int updateByPrimaryKey(Paper record);
    List<Paper> getPapers();
    List<Paper> getPapersByCon(@Param("userId")Long userId,@Param("title")String title,@Param("state")String state);
}