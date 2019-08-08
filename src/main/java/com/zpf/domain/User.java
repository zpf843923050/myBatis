package com.zpf.domain;


import java.util.List;

public class User {
    private Integer id;//用户id,主键
    private String username;//用户名
    private String loginname;//登录名
    private String password;//密码
    private String phone;//联系手机号
    private String adress;//收获地址
    //用于与订单为一对多关系，一个用户拥有多个订单.
    private List<Order> orders;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    public User( String username, String loginname, String password, String phone, String adress ) {

        this.username = username;
        this.loginname = loginname;
        this.password = password;
        this.phone = phone;
        this.adress = adress;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", loginname="
                + loginname + ", password=" + password + ", phone=" + phone
                + ", address=" + adress + "]";
    }
}
