package com.example.rank.dao;

import com.example.rank.model.PaperType;
import com.example.rank.param.AddPaperTypeParam;
import com.example.rank.param.DeletePaperTypeParam;

import java.util.List;

public interface PaperTypeMapper {
    void add(AddPaperTypeParam param);
    List<PaperType> getPaperTypes(Long userId);
    void delete(DeletePaperTypeParam param);

}