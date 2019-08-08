package com.zpf.domain;

import javax.print.DocFlavor;
import java.io.InputStream;

public class Employee {
    private Integer id;
    private String Loginname;
    private String password;
    private String name;
    private String sex;
    private Integer age;
    private String  phone;
    private String sal;
    private String state;

    public Employee() {
    }

    public Employee(String loginname, String password, String name, String sex, Integer age, String phone, String sal, String state) {
        Loginname = loginname;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.sal = sal;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return Loginname;
    }

    public void setLoginname(String loginname) {
        Loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    @Override
    public  String toString(){
        return Loginname+","+password+","+name+","+sex+","+age+","+phone+","+sal+","+state;
    }

}
