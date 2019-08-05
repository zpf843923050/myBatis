package com.zpf.domain;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Card {
    private Integer id;//主键id
    private String code;//身份证编号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "[" + id + "," + code + "]";
    }
}
