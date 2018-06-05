package com.example.rank.controller;

import com.example.rank.model.Paper;
import com.example.rank.model.User;
import com.example.rank.param.AddPaperParam;
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
import java.util.Date;
import java.util.List;

@RestController
public class ArticleController {
    @Resource
    private ArticleService articleService;


    @ResponseBody
    @RequestMapping(value = "/viewpaper",method = RequestMethod.GET)
    public String viewPaper(HttpServletResponse response, HttpServletRequest request, PaperParam param){
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        param.setId(Long.valueOf(request.getParameter("paperid")));
        List<Paper> papers=articleService.getArticleListByCon(param);
        for(Paper paper:papers){
            Gson gson=new Gson();
            System.out.print("2222222222222222"+paper);
            return gson.toJson(paper);
        }
        return null;

    }

    @ResponseBody
    @RequestMapping(value = "/addpaper",method = RequestMethod.GET)
    public String addPaper(HttpServletResponse response, HttpServletRequest request, AddPaperParam param){
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader( "Access-Control-Allow-Credentials","true" );
        User user=(User)request.getSession(false).getAttribute("USER");
        param.setContent(request.getParameter("content"));
        System.out.print("qqqqqqqqqqqqqqqqqqqqqq"+param.getContent());
        param.setTitle(request.getParameter("title"));
        param.setCreatedtime(new Date());
        param.setReadNum(1);
        param.setState("false");
        param.setUserid(user.getId());
        articleService.addArticle(param);
        return "SUCCESS";

    }


    @ResponseBody
    @RequestMapping(value = "/getPaperList",method = RequestMethod.GET)
    public String getArticleList(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Paper> papers=articleService.getArticleList();
        Gson gson=new Gson();
        return gson.toJson(papers);
    }
    @ResponseBody
    @RequestMapping(value = "/getPaperListByUser",method = RequestMethod.GET)
    public String getArticleListByUser(HttpServletResponse response,PaperParam param,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader( "Access-Control-Allow-Credentials","true" );
        Gson gson=new Gson();
        User user=(User)request.getSession(false).getAttribute("USER");
        param.setUserid(user.getId());
        List<Paper> papers=articleService.getArticleListByCon(param);
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
        }catch (ParseException e) {
            e.printStackTrace();
        }
        if(request.getParameter("userId")!=null && request.getParameter("userId")!=""){
            param.setUserid(Long.valueOf(request.getParameter("userId")));
        }
        List<Paper> papers=articleService.getArticleListByCon(param);
        Gson gson=new Gson();
        return gson.toJson(papers);
    }
    static boolean checknull(String date){
        if(date!=null && date!="") {
            return true;
        }
        return false;
    }


}
