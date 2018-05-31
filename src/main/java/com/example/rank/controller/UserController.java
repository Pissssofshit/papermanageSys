package com.example.rank.controller;

import com.example.rank.model.User;
import com.example.rank.param.UserParam;

import com.example.rank.service.UserService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class UserController {
    @Resource
    UserService userService;
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletResponse response, HttpServletRequest request, UserParam param) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        System.out.print("11111111111111111");
        param.setIphone(request.getParameter("username"));
        param.setPassword(request.getParameter("password"));
        User user=userService.login(param);
        Gson gson=new Gson();
        if(user!=null){
            request.getSession().setAttribute("USER",user);
            System.out.print("session"+gson.toJson(request.getSession().getAttribute("USER"))+"session");
            System.out.print(gson.toJson(user));
            return gson.toJson(user);
        }
        return gson.toJson("flase");
    }
}
