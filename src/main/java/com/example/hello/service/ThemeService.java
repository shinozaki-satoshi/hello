package com.example.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hello.entity.Theme;
import com.example.hello.mapper.ThemeMapper;

@Service
public class ThemeService {
    @Autowired
    ThemeMapper themeMapper;

    public List<Theme> getTheme(){
        return themeMapper.findAllThemes(); // ThemeMapperを使用してすべてのレコードを取得する
    }
    
}