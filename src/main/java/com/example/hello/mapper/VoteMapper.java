package com.example.hello.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.hello.entity.Vote;

@Mapper
public interface VoteMapper {
    void voteAnswer(Vote vote);
} 
