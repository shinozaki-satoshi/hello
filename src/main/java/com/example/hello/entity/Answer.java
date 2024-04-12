package com.example.hello.entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Answer {

    private String answerId;
    private String themeId;
    private String answer;
    private String voteNum;
    private String time;
}