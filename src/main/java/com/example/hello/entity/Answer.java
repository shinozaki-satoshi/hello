package com.example.hello.entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Answer {

    private String answerId;
    private String theme_id;
    private String answer;
    private String vote_num;
    private String time;
}