package com.zpf.domain;

public class User {
    //用户标识
    private Integer ID;
    //用户姓名
    private String NAME;
    //    用户性别
    private String SEX;
    //用户年龄
    private Integer AGE;

    //无参构造器

    public User() {
    }
    //有参构造器


    public User(String NAME, String SEX, Integer AGE) {
        this.NAME = NAME;
        this.SEX = SEX;
        this.AGE = AGE;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public Integer getAGE() {
        return AGE;
    }

    public void setAGE(Integer AGE) {
        this.AGE = AGE;
    }
}
