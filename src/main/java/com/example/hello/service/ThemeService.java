package com.example.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hello.bean.Theme;
import com.example.hello.mapper.ThemeMapper;

@Service
public class ThemeService {

    @Autowired
    ThemeMapper themeMapper;

    public List<Theme> getAllTheme(){
        return themeMapper.getAllTheme();
    }

    public Theme getTheme(Integer themeId){
        return themeMapper.getTheme(themeId);
    }
    
    public Void registerTheme(Integer themeId, String answer){
        return themeMapper.registerTheme(themeId, answer);
    }

    public List<Theme> getOverTheme(){
        return themeMapper.getOverTheme();
    }
}