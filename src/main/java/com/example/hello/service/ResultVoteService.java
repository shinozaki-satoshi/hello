package com.example.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hello.bean.ResultVote;
import com.example.hello.mapper.ResultVoteMapper;

@Service
public class ResultVoteService {

    @Autowired
    ResultVoteMapper resultVoteMapper;

    public List<ResultVote> getAnswersRank(Integer themeId){
        return resultVoteMapper.getAnswersRank(themeId);
    }
}
