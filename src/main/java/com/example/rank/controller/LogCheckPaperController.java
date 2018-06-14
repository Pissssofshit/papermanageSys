package com.example.rank.controller;


import com.example.rank.model.LogCheckPaper;
import com.example.rank.param.LogCheckPaperParam;
import com.example.rank.service.LogCheckPaperService;
import com.example.rank.util.CrossDomain;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class LogCheckPaperController {

    @Resource
    LogCheckPaperService logCheckPaperService;


    @ResponseBody
    @RequestMapping(value = "/getLogs",method = RequestMethod.GET)
    public String getLogs(HttpServletResponse response, HttpServletRequest request,LogCheckPaperParam param){
        CrossDomain crossDomain=new CrossDomain();
        crossDomain.solveCrossDomain(response);
        param.setPageSize(30);
        param.setPageStart(Integer.valueOf(request.getParameter("pageNo"))*30-30);
        List<LogCheckPaper> logCheckPapers=logCheckPaperService.getLogs(param);
        Gson gson=new Gson();
        return gson.toJson(logCheckPapers);

    }
    @ResponseBody
    @RequestMapping(value = "/getTotal",method = RequestMethod.GET)
    public int getTotal(HttpServletResponse response, HttpServletRequest request){
        CrossDomain crossDomain=new CrossDomain();
        crossDomain.solveCrossDomain(response);
        return logCheckPaperService.getTotal();
    }
}
