package com.example.hello.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.hello.bean.Answer;

@Mapper
public interface AnswerMapper {
    Void registerAnswer(Integer themeId, String answer,String userName);
    List<Answer> getAnswers(Integer themeId);
    Answer getAnswer (Integer answerId);
    List<Answer> answerCheck(String userName);
}