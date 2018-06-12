package com.example.rank.controller;

import com.example.rank.model.User;
import com.example.rank.param.UserParam;

import com.example.rank.service.UserService;
import com.example.rank.util.CrossDomain;
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
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletResponse response, HttpServletRequest request, UserParam param) {
        CrossDomain crossDomain=new CrossDomain();
        crossDomain.solveCrossDomain(response);
        User user=userService.login(param);
        Gson gson=new Gson();
        if(user!=null){
            request.getSession().setAttribute("USER",user);
            request.getSession().setMaxInactiveInterval(30 * 60);
            return gson.toJson(user);
        }
        return gson.toJson("false");
    }
    @ResponseBody
    @RequestMapping(value = "/getLoginInfo",method = RequestMethod.POST)
    public String getLoginInfo(HttpServletResponse response,HttpServletRequest request){
        CrossDomain crossDomain=new CrossDomain();
        crossDomain.solveCrossDomain(response);
        User user=(User)request.getSession(false).getAttribute("USER");
        Gson gson=new Gson();
        return gson.toJson(user);

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
