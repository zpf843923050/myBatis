package com.zpf.domain;

public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    //关联的Clazz对象-外键->clazz的id
    private Clazz clazz;//Clazz包含id和code //学生和班级是多对一关系，clazz来映射多对一关联关系,表示该学生所属的班级

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

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", sex=" + sex
                + ", age=" + age + "]";
    }
}
