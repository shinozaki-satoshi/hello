package com.example.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hello.bean.Vote;
import com.example.hello.mapper.VoteMapper;

@Service
public class VoteService {

    @Autowired
    VoteMapper voteMapper;

    public void voteAnswer(String userName, Integer themeId, Integer answerId){

        Vote vote = new Vote(userName,themeId,answerId);
        voteMapper.voteAnswer(vote);
    }

    public Vote voteCheck(String userName, Integer themeId){

        return voteMapper.voteCheck(userName,themeId);
    }

    public List<Vote> voteCheck(String userName){
        return voteMapper.voteCheckbyUser(userName);
    }

    public void votedelete(String userName, Integer themeId){
        voteMapper.votedelete(userName,themeId);
    }
}
