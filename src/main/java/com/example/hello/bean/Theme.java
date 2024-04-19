package com.example.hello.bean;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Theme {

    private String themeId;

    private String themeName;

    private Date deadlineFrom;

    private Date deadlineTo;
    private String userName;
}