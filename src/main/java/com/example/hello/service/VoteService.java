package com.example.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hello.bean.Vote;
import com.example.hello.mapper.VoteMapper;

@Service
public class VoteService {

    @Autowired
    VoteMapper voteMapper;

    public void voteAnswer(String userName, Integer themeId, Integer answerId){

        Vote vote = new Vote(themeId,userName,answerId);
        voteMapper.voteAnswer(vote);
    }
}
