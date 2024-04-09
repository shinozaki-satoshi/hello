package com.example.hello.mapper;

import com.example.hello.entity.Theme;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ThemeMapper {

    @Select("SELECT * FROM Theme")
    List<Theme> findAllThemes();
}