package com.example.rank.dao;

import com.example.rank.model.rank;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface rankMapper {



    List<rank> getRankBySortType(@Param("sortType")String sortType);
    List<rank> getRank();
    void updateHeat(@Param("id")int id,@Param("heat")int heat);
}