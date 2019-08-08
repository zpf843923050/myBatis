package com.zpf.domain;

import java.util.List;

public class Article {
    private Integer id;//商品id,主键
    private String name;//商品名称
    private Double price;//商品价格
    private String remark;//商品描述
    //商品和订单之间是多对多关系.即一个商品有多个订单.
    private List<Order> orders;

    public Article() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Article(String name, Double price, String remark) {

        this.name = name;
        this.price = price;
        this.remark = remark;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Article [id=" + id + ", name=" + name + ", price=" + price
                + ", remark=" + remark + "]";
    }
}
