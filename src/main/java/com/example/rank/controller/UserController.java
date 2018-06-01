package com.example.rank.controller;

import com.example.rank.model.User;
import com.example.rank.param.UserParam;

import com.example.rank.service.UserService;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class UserController extends HandlerInstantiator {
    @Resource
    UserService userService;
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletResponse response, HttpServletRequest request, UserParam param) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader( "Access-Control-Allow-Credentials","true" );
        System.out.print("11111111111111111");
        param.setIphone(request.getParameter("username"));
        param.setPassword(request.getParameter("password"));
        User user=userService.login(param);
        Gson gson=new Gson();
        if(user!=null){
            request.getSession().setAttribute("USER",user);
            request.getSession().setMaxInactiveInterval(30 * 60);
            System.out.print("session"+gson.toJson(request.getSession().getAttribute("USER"))+"session");
            System.out.print(gson.toJson(user));
            return gson.toJson(user);
        }

        return gson.toJson("flase");
    }

    @Override
    public JsonDeserializer<?> deserializerInstance(DeserializationConfig deserializationConfig, Annotated annotated, Class<?> aClass) {
        return null;
    }

    @Override
    public KeyDeserializer keyDeserializerInstance(DeserializationConfig deserializationConfig, Annotated annotated, Class<?> aClass) {
        return null;
    }

    @Override
    public JsonSerializer<?> serializerInstance(SerializationConfig serializationConfig, Annotated annotated, Class<?> aClass) {
        return null;
    }

    @Override
    public TypeResolverBuilder<?> typeResolverBuilderInstance(MapperConfig<?> mapperConfig, Annotated annotated, Class<?> aClass) {
        return null;
    }

    @Override
    public TypeIdResolver typeIdResolverInstance(MapperConfig<?> mapperConfig, Annotated annotated, Class<?> aClass) {
        return null;
    }
}
