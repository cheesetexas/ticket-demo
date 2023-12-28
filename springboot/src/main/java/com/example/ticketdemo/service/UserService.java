package com.example.ticketdemo.service;

import com.example.ticketdemo.pojo.cmd.UserLoginCmd;
import com.example.ticketdemo.pojo.model.User;

public interface UserService {

    User login(UserLoginCmd cmd);
    User queryUserByUsername(String username);
}
