package com.example.hello.bean;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Answer {

    private Integer answerId;
    private String answer;
    private String time;
    private Integer themeId;
    private String userName;
}