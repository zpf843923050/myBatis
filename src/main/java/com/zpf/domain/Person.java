package com.zpf.domain;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Person {
    private Integer id;//主键id
    private String name;//姓名
    private String sex;//性别
    private Integer age;//年龄
    private Card card;//关联

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[" + id + "," + name + "," + sex + "," + age + "," + card + "]";
    }
}
