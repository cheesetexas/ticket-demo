package com.example.ticketdemo.service.impl;

import com.example.ticketdemo.mapper.UserMapper;
import com.example.ticketdemo.pojo.cmd.UserLoginCmd;
import com.example.ticketdemo.pojo.model.User;
import com.example.ticketdemo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User login(UserLoginCmd cmd) {
        User user = queryUserByUsername(cmd.getUsername());
        if (Objects.isNull(user)) {
            return null;
        }
        return Objects.equals(cmd.getPassword(), user.getPassword()) ? user : null;
    }

    @Override
    public User queryUserByUsername(String username) {
        return userMapper.queryUserByUsername(username);
    }
}
