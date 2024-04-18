package com.example.hello.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResultVote {
    private String answerId;
    private String themeId;
    private String answer;
    private String voteCount;
    private String time;
}
