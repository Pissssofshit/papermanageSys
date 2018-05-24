package com.example.rank.controller;

import com.example.rank.model.rank;
import com.example.rank.service.rankService;
import com.google.gson.Gson;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

public class RankController {
    @Resource
    private rankService rankService;

    @RequestMapping("/getRankList")
    public String getRankList(){
        List<rank> ranks=rankService.getRankByHeat();
        Gson gson=new Gson();
        return gson.toJson(ranks);
    }



}
