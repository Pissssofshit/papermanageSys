package com.example.rank.service.serviceimpl;

import com.example.rank.dao.PaperMapper;
import com.example.rank.model.Paper;
import com.example.rank.param.AddPaperParam;
import com.example.rank.param.PaperParam;
import com.example.rank.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    PaperMapper paperMapper;

    @Resource
    ArticleService articleService;

    @Override
    public void addArticle(AddPaperParam param) {
        param.setCreatedtime(new Date());
        param.setReadNum(1);
        param.setState("false");
        paperMapper.add(param);
    }

    @Override
    public void deleteArticle(PaperParam param) {
        paperMapper.delete(param);
    }

    @Override
    public List<Paper> getArticleList() {
        return paperMapper.getPapers();
    }

    @Override
    public List<Paper> getArticleListByCon(PaperParam param) {
        return paperMapper.getPapersByCon(param.getId(),param.getUserid(),param.getTitle(),param.getState(),param.getCreatedtimeOne(),param.getCreatedtimeTwo(),param.getUpdatedtimeOne(),param.getUpdatedtimeTwo());



    }

    @Override
    public Paper viewPaper(PaperParam param) {
        List<Paper> papers=articleService.getArticleListByCon(param);
        for(Paper paper:papers){
            param.setReadNum(paper.getReadNum()+1);
            paperMapper.updateReadNum(param);
            return paper;
        }
        return null;
    }

}
