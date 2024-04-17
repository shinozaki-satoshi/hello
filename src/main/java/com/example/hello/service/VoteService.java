package com.example.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hello.entity.Vote;
import com.example.hello.mapper.VoteMapper;

@Service
public class VoteService {

    @Autowired
    VoteMapper voteMapper;

    public void voteAnswer(String userName, Integer themeId, Integer answerId){

        Vote vote = new Vote(themeId,userName,answerId);
        System.out.println("サービスだよ！！！！"+vote);
        voteMapper.voteAnswer(vote);
    }
}
