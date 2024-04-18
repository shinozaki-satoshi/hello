package com.example.hello.bean;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Theme {

    private String themeId;

    private String themeName;

    private String deadlineFrom;

    private String deadlineTo;
}