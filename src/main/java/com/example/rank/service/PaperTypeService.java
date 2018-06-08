package com.example.rank.service;

import com.example.rank.model.PaperType;
import com.example.rank.param.AddPaperTypeParam;
import com.example.rank.param.DeletePaperTypeParam;

import java.util.List;

public interface PaperTypeService {
    /**
     * 增加类型
     */
    void addPaperType(AddPaperTypeParam param);

    /**
     * 删除类型（若类型有文章，则删除失败）
     */
    void deletePaperType(DeletePaperTypeParam param);

    /**
     * 修改类型
     */

    /**
     * 查询类型列表
     */
    List<PaperType> getPaperTypes(Long userId);
}
