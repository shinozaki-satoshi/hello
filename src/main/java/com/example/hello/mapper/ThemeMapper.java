package com.example.hello.mapper;

import com.example.hello.entity.Theme;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ThemeMapper {

    List<Theme> findAllThemes();
    Theme getTheme(Integer themeId);
}