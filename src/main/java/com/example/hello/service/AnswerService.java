package com.example.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hello.entity.Answer;
import com.example.hello.mapper.AnswerMapper;

@Service
public class AnswerService {

    private final AnswerMapper answerMapper;

    @Autowired
    public AnswerService(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    public Void registerAnswer(Integer themeId, String answer){
        return answerMapper.registerTheme(themeId, answer);
    }

    public List<Answer> getAnswers(Integer themeId){
        return answerMapper.getAnswers(themeId);
    }

    public Answer getAnswer(Integer answerId){
        return answerMapper.getAnswer(answerId);
    }

    public Void voteAnswer(Integer answerId){
        return answerMapper.voteAnswer(answerId);
    }
    
    
}