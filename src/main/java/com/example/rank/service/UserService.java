package com.example.rank.service;

import com.example.rank.model.User;
import com.example.rank.param.UserParam;


public interface UserService {
    User login(UserParam parm);
}
