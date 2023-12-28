package com.example.ticketdemo.pojo.cmd;

import lombok.Data;

@Data
public class UserLoginCmd {
    private String username;
    private String password;
}
