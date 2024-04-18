package com.example.hello.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.hello.bean.ResultVote;

@Mapper
public interface ResultVoteMapper {
    List<ResultVote> getAnswersRank(Integer themeId);
}
