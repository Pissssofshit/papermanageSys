package com.example.rank.controller;

import com.example.rank.model.rank;
import com.example.rank.service.rankService;
import com.google.gson.Gson;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class RankController {
    @Resource
    private rankService rankService;

    @ResponseBody
    @RequestMapping(value = "/getRankList",method = RequestMethod.GET)
    public String getRankList(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<rank> ranks=rankService.getRankByHeat();
        Gson gson=new Gson();
        return gson.toJson(ranks);
    }



}
