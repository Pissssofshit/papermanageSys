package com.example.rank.service.serviceimpl;

import com.example.rank.dao.UserMapper;

import com.example.rank.model.User;
import com.example.rank.param.UserParam;
import com.example.rank.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public User login(UserParam param) {
        return userMapper.login(param.getIphone(),param.getPassword());
    }
}
