package com.example.hello.bean;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Answer {

    private String answerId;
    private String themeId;
    private String answer;
    private String userName;
    private String time;
}