package com.example.hello.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.hello.bean.Theme;

@Mapper
public interface ThemeMapper {

    List<Theme> getAllTheme();
    Theme getTheme(Integer themeId);
    Void registerTheme(Integer themeId, String anser);
    List<Theme> getOverTheme();
}