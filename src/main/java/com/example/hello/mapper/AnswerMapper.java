package com.example.hello.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.hello.entity.Answer;

@Mapper
public interface AnswerMapper {
    Void registerTheme(Integer themeId, String answer);
    List<Answer> getAnswers(Integer themeId);
    Answer getAnswer (Integer answerId);
}