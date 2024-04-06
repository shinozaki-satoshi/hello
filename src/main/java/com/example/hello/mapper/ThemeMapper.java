package com.example.hello.mapper;

import com.example.hello.entity.Theme;
import java.util.List;

public interface ThemeMapper {
    public List<Theme> findAllThemes();
}