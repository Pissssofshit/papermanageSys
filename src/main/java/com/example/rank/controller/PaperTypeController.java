package com.example.rank.controller;

import com.example.rank.model.PaperType;
import com.example.rank.model.User;
import com.example.rank.param.AddPaperTypeParam;
import com.example.rank.param.DeletePaperTypeParam;
import com.example.rank.service.PaperTypeService;
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
public class PaperTypeController {
    @Resource
    PaperTypeService paperTypeService;


    @ResponseBody
    @RequestMapping(value = "/addPaperType",method = RequestMethod.POST)
    public String addPaperType(AddPaperTypeParam param, HttpServletRequest request,HttpServletResponse response){
        CrossDomain crossDomain=new CrossDomain();
        crossDomain.solveCrossDomain(response);
        param.setUserid(((User)request.getSession(false).getAttribute("USER")).getId());
        paperTypeService.addPaperType(param);
        List<PaperType> paperTypes=paperTypeService.getPaperTypes(param.getUserid());
        Gson gson=new Gson();
        return gson.toJson(paperTypes);
    }


    @ResponseBody
    @RequestMapping(value = "/getPaperTypes",method = RequestMethod.POST)
    public String getPaperTypes(HttpServletRequest request, HttpServletResponse response){
        CrossDomain crossDomain=new CrossDomain();
        crossDomain.solveCrossDomain(response);
        List<PaperType> paperTypes=paperTypeService.getPaperTypes(((User)request.getSession(false).getAttribute("USER")).getId());
        Gson gson=new Gson();
        return gson.toJson(paperTypes);

    }

    @ResponseBody
    @RequestMapping(value = "/deletePaperType",method = RequestMethod.GET)
    public String deletePaperType(HttpServletResponse response, HttpServletRequest request, DeletePaperTypeParam param){
        CrossDomain crossDomain=new CrossDomain();
        crossDomain.solveCrossDomain(response);
        param.setUserid(((User)request.getSession(false).getAttribute("USER")).getId());
        paperTypeService.deletePaperType(param);
        List<PaperType> paperTypes=paperTypeService.getPaperTypes(param.getUserid());
        Gson gson=new Gson();
        return gson.toJson(paperTypes);
    }
}
