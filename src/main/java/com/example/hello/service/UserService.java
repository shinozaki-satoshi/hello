package com.example.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.hello.bean.Account;
import com.example.hello.mapper.AccountMapper;

import org.springframework.ui.Model;

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

    public void registUser(String username, String passWard){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Account account = new Account(username, encoder.encode(passWard));
        accountMapper.registUser(account);
    }

    //ログインユーザーを表示させるためのやつ
    public Model getUser(Model model){
        final String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", name);
        return model;
    }

    public String getUserName(){
        final String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return name;
    }

}
