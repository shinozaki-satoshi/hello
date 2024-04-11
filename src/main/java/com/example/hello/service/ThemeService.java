package com.example.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hello.entity.Theme;
import com.example.hello.mapper.ThemeMapper;

@Service
public class ThemeService {

    private final ThemeMapper themeMapper;

    @Autowired
    public ThemeService(ThemeMapper themeMapper) {
        this.themeMapper = themeMapper;
    }

    public List<Theme> getAllTheme(){
        return themeMapper.findAllThemes();
    }

    public Theme getTheme(Integer themeId){
        return themeMapper.getTheme(themeId);
    }
}