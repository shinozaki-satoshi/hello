package com.example.hello.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vote {
    private Integer themeId;
    private String userName;
    private Integer answerId;
    private String time;

    public Vote(Integer themeId, String userName, Integer answerId) {
        this.themeId = themeId;
        this.userName = userName;
        this.answerId = answerId;
    }
}
