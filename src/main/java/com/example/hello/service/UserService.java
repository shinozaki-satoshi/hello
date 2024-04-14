package com.example.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.hello.entity.Account;
import com.example.hello.mapper.AccountMapper;

@Component
public class UserService implements UserDetailsService{

    @Autowired
    AccountMapper accountMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountMapper.selectByUsername(username);
        if (account == null){
            throw new UsernameNotFoundException(username);
        }
    
       return accountMapper.selectByUsername(username);
    }
}
