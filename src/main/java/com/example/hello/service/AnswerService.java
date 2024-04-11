package com.example.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hello.mapper.AnswerMapper;

@Service
public class AnswerService {

    private final AnswerMapper answerMapper;

    @Autowired
    public AnswerService(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    public Void registerAnswer(Integer themeId, String anser){
        return answerMapper.registerTheme(themeId, anser);
    }
}