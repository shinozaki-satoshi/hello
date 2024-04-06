package com.example.hello.entity;

public class Theme {

    private String id;
    private String themeId;
    private String themeName;
    private String deadlineFrom;
    private String deadlineTo;

    // コンストラクタ、getter、setterなどを定義する

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getDeadlineFrom() {
        return deadlineFrom;
    }

    public void setDeadlineFrom(String deadlineFrom) {
        this.deadlineFrom = deadlineFrom;
    }

    public String getDeadlineTo() {
        return deadlineTo;
    }

    public void setDeadlineTo(String deadlineTo) {
        this.deadlineTo = deadlineTo;
    }

    // デフォルトコンストラクタ
    public Theme() {
    }

    // 引数を持つコンストラクタ
    public Theme(String id, String themeId, String themeName, String deadlineFrom, String deadlineTo) {
        this.id = id;
        this.themeId = themeId;
        this.themeName = themeName;
        this.deadlineFrom = deadlineFrom;
        this.deadlineTo = deadlineTo;
    }
}