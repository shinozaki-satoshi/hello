package com.example.hello.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.hello.bean.Theme;

@Mapper
public interface ThemeMapper {

    List<Theme> getAllTheme();
    Theme getTheme(Integer themeId);
    void registerTheme(Theme theme);
    List<Theme> getOverTheme();
}