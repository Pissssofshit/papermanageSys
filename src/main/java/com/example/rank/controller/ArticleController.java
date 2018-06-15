package com.example.rank.controller;

import com.example.rank.model.Paper;
import com.example.rank.model.User;
import com.example.rank.param.AddPaperParam;
import com.example.rank.param.PaperParam;
import com.example.rank.service.ArticleService;
import com.example.rank.util.CrossDomain;
import com.google.gson.Gson;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
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
    @RequestMapping(value = "/deletePaper",method = RequestMethod.POST)
    public String deletePaper(HttpServletResponse response, HttpServletRequest request, PaperParam param){
        CrossDomain crossDomain=new CrossDomain();
        crossDomain.solveCrossDomain(response);
        User user=(User)request.getSession(false).getAttribute("USER");
        param.setUserid(user.getId());
        articleService.deleteArticle(param);
        return "SUCCESS";
    }


    @ResponseBody
    @RequestMapping(value = "/updatePaper",method = RequestMethod.POST)
    public String updatePaper(HttpServletResponse response, HttpServletRequest request, PaperParam param){
        CrossDomain crossDomain=new CrossDomain();
        crossDomain.solveCrossDomain(response);
        articleService.updateArticle(param);
        return "SUCCESS";

    }


    @ResponseBody
    @RequestMapping(value = "/checkPaper",method = RequestMethod.POST)
    public String checkPaper(HttpServletResponse response, HttpServletRequest request, PaperParam param){
        CrossDomain crossDomain=new CrossDomain();
        crossDomain.solveCrossDomain(response);
        User user=(User)request.getSession(false).getAttribute("USER");
        param.setUserid(user.getId());
        articleService.checkArticle(param);
        return "SUCCESS";
    }


    @ResponseBody
    @RequestMapping(value = "/submitCheckPaper",method = RequestMethod.POST)
    public String submitCheckPaper(HttpServletResponse response, HttpServletRequest request, PaperParam param){
        CrossDomain crossDomain=new CrossDomain();
        crossDomain.solveCrossDomain(response);
        User user=(User)request.getSession(false).getAttribute("USER");
        param.setUserid(user.getId());
        articleService.submitCheckArticle(param);
        return "SUCCESS";
    }


    @ResponseBody
    @RequestMapping(value = "/viewpaper",method = RequestMethod.POST)
    public String viewPaper(HttpServletResponse response, HttpServletRequest request, PaperParam param){
        CrossDomain crossDomain=new CrossDomain();
        crossDomain.solveCrossDomain(response);
        Paper paper=articleService.viewPaper(param);
        Gson gson=new Gson();
        return gson.toJson(paper);
    }

    @ResponseBody
    @RequestMapping(value = "/addpaper",method = RequestMethod.POST)
    public String addPaper(HttpServletResponse response, HttpServletRequest request, AddPaperParam param){
        CrossDomain crossDomain=new CrossDomain();
        crossDomain.solveCrossDomain(response);
        User user=(User)request.getSession(false).getAttribute("USER");
        param.setUserid(user.getId());
        articleService.addArticle(param);
        return "SUCCESS";

    }


    @ResponseBody
    @RequestMapping(value = "/getPaperList",method = RequestMethod.POST)
    public String getArticleList(HttpServletResponse response){
        CrossDomain crossDomain=new CrossDomain();
        crossDomain.solveCrossDomain(response);
        List<Paper> papers=articleService.getArticleList();
        Gson gson=new Gson();
        return gson.toJson(papers);
    }


    @ResponseBody
    @RequestMapping(value = "/getPaperListByUser",method = RequestMethod.POST)
    public String getArticleListByUser(HttpServletResponse response,PaperParam param,HttpServletRequest request){
        CrossDomain crossDomain=new CrossDomain();
        crossDomain.solveCrossDomain(response);
        Gson gson=new Gson();
        User user=(User)request.getSession(false).getAttribute("USER");
        param.setUserid(user.getId());
        List<Paper> papers=articleService.getArticleListByCon(param);
        return gson.toJson(papers);
    }


    @ResponseBody
    @RequestMapping(value = "/getPaperListByCon",method = RequestMethod.POST)
    public String getArticleListBycon(PaperParam param,HttpServletResponse response, HttpServletRequest request){
        CrossDomain crossDomain=new CrossDomain();
        crossDomain.solveCrossDomain(response);
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
