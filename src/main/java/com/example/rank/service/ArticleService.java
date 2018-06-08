package com.example.rank.service;

import com.example.rank.model.Paper;
import com.example.rank.param.AddPaperParam;
import com.example.rank.param.PaperParam;

import java.util.List;

public interface ArticleService {
    /**
     * 登记文章
     */
    void addArticle(AddPaperParam param);

    /**
     * 删除文章
     */
    void deleteArticle(PaperParam param);


    /**
     * 更新文章
     */


    /**
     * 返回文章列表
     */
    List<Paper> getArticleList();

    /**
     *根据createtime的2个是时间区间查询文章列表
     */

    List<Paper> getArticleListByCon(PaperParam param);

    /**
     *查看文章
     */
    Paper viewPaper(PaperParam param);


}
