package com.example.ticketdemo.mapper;

import com.example.ticketdemo.pojo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User queryUserByUsername(String username);
}
