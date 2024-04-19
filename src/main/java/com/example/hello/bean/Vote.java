package com.example.hello.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vote {
    private String userName;
    private Integer themeId;
    private Integer answerId;
    private String time;

    public Vote(String userName, Integer themeId,Integer answerId) {
        this.themeId = themeId;
        this.userName = userName;
        this.answerId = answerId;
    }
}
