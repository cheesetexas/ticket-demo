package com.example.ticketdemo.controller;

import com.example.ticketdemo.pojo.cmd.UserLoginCmd;
import com.example.ticketdemo.pojo.model.Result;
import com.example.ticketdemo.pojo.model.User;
import com.example.ticketdemo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<?> login(@RequestBody UserLoginCmd cmd, HttpServletResponse response) throws JsonProcessingException {
        User user = userService.login(cmd);
        if (Objects.isNull(user)) {
            return Result.error("用户名或密码错误");
        }
        setUserInfoCookie(user, response);
        return Result.success(user);
    }

    private void setUserInfoCookie(User user, HttpServletResponse response) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String userInfo = URLEncoder.encode(om.writeValueAsString(user), StandardCharsets.UTF_8);
        Cookie userCookie = new Cookie("user", userInfo);
        userCookie.setPath("/");
        userCookie.setMaxAge(3600 * 24);
        response.addCookie(userCookie);
    }
}
