package com.zpf.domain;

import java.util.List;

public class Clazz {
    //班级ID主键
    private Integer id;
    //班级代码
    private String code;

    //班级名称
    private String name;
    private List<Student>students;//一个班级有多个学生,用List<Student>来映射一对多的关系,表示一个班级有多个学生

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Clazz [id=" + id + ", code=" + code + "]";
    }

}
