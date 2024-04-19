package com.example.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hello.bean.Answer;
import com.example.hello.mapper.AnswerMapper;

@Service
public class AnswerService {
    
    @Autowired
    AnswerMapper answerMapper;

    public Void registerAnswer(Integer themeId, String answer, String userName){
        return answerMapper.registerAnswer(themeId, answer, userName);
    }

    public List<Answer> getAnswers(Integer themeId){
        return answerMapper.getAnswers(themeId);
    }

    public Answer getAnswer(Integer answerId){
        return answerMapper.getAnswer(answerId);
    }

    public List<Answer> answerCheck(String userName){
        return answerMapper.answerCheck(userName);
    }

}