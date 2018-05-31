package com.example.rank.controller;

import com.example.rank.model.Paper;
import com.example.rank.param.PaperParam;
import com.example.rank.service.ArticleService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @ResponseBody
    @RequestMapping(value = "/getPaperList",method = RequestMethod.GET)
    public String getArticleList(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Paper> papers=articleService.getArticleList();
        Gson gson=new Gson();
        System.out.print(gson.toJson(papers));
        return gson.toJson(papers);
    }
    @ResponseBody
    @RequestMapping(value = "/getPaperListByCon",method = RequestMethod.GET)
    public String getArticleListBycon(PaperParam param,HttpServletResponse response, HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", "*");
        param.setState(request.getParameter("state"));
        param.setTitle(request.getParameter("title"));
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if(checknull(request.getParameter("date1"))){
                param.setCreatedtimeOne(format1.parse(request.getParameter("date1")));
            }
            if(checknull(request.getParameter("date2"))){
                param.setCreatedtimeTwo(format1.parse(request.getParameter("date2")));
            }
            if(checknull(request.getParameter("date3"))){
                param.setUpdatedtimeOne(format1.parse(request.getParameter("date3")));
            }
            if(checknull(request.getParameter("date4"))){
                param.setUpdatedtimeTwo(format1.parse(request.getParameter("date4")));
            }

            System.out.print(param.getCreatedtimeOne()+"&&&&&&&&");
        }catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.print("********************"+request.getParameter("userId")+request.getParameter("date1")+request.getParameter("date2"));

        if(request.getParameter("userId")!=null && request.getParameter("userId")!=""){
            param.setUserid(Long.valueOf(request.getParameter("userId")));
        }

        List<Paper> papers=articleService.getArticleListByCon(param);
        Gson gson=new Gson();
        System.out.print(gson.toJson(papers));
        return gson.toJson(papers);
    }
    static boolean checknull(String date){
        if(date!=null && date!="") {
            return true;
        }
        return false;
    }


}
