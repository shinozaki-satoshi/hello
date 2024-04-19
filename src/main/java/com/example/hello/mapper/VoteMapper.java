package com.example.hello.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.hello.bean.Vote;

@Mapper
public interface VoteMapper {
    void voteAnswer(Vote vote);
    Vote voteCheck(String userName, Integer themeId);
    void votedelete(String userName, Integer themeId);
} 
