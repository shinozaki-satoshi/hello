package com.example.hello.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnswerMapper {
    Void registerTheme(Integer themeId, String anser);
}