package com.example.rank.service.serviceimpl;

import com.example.rank.dao.PaperMapper;
import com.example.rank.model.Paper;
import com.example.rank.param.PaperParam;
import com.example.rank.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    PaperMapper paperMapper;
    @Override
    public List<Paper> getArticleList() {
        return paperMapper.getPapers();
    }

    @Override
    public List<Paper> getArticleListByCon(PaperParam param) {
        System.out.print(param.getUserid()+param.getTitle()+param.getState());

        return paperMapper.getPapersByCon(param.getUserid(),param.getTitle(),param.getState());



    }

}
