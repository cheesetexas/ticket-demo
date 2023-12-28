package com.example.ticketdemo.service.impl;

import com.example.ticketdemo.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceImplTests {
    @Resource
    private UserService userService;

    @Test
    public void testQueryUserByUsername() {
        System.out.println(userService.queryUserByUsername("test"));
    }
}
