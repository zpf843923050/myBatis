package com.zpf.domain;

import java.util.List;

public class Clazz {
    //班级ID主键
    private Integer id;
    //班级代码
    private String code;

    private List<Student>students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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
