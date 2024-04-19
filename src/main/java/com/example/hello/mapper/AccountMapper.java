package com.example.hello.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.hello.bean.Account;

@Mapper
public interface AccountMapper {
    Account selectByUsername(String username);
    void registUser(Account account);
}
