package com.zpf.Test;

import com.zpf.domain.Article;
import com.zpf.domain.Order;
import com.zpf.domain.User;
import com.zpf.mapper_2.OrderMapper;
import com.zpf.mapper_2.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class oneToManyTest {
    public static void main(String[] args) throws IOException {
        //读取Mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-conf.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        testSelectOrderById(session);
        System.out.println("---------------------");
        testSelectUserById(session);
        session.commit();
        session.close();
    }

    /**
     * 测试一对多关系User(一)的时候级联查询Order订单(多)
     *
     * @param session
     */
    public static void testSelectUserById(SqlSession session) {
        //获取userMapper代理对象
        UserMapper um = session.getMapper(UserMapper.class);
        User user = um.selectUserById(1);
        //查看查询到的User对象信息
        System.out.println(user.getId() + user.getUsername());
        //查看user对象关联的订单信息
        List<Order> orders = user.getOrders();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public static void testSelectOrderById(SqlSession session) {
        //获得OrderMapper的代理对象
        OrderMapper om = session.getMapper(OrderMapper.class);
        Order order = om.selectOrderById(2);
        //查看
        System.out.println(order.getId()+order.getCode()+order.getTotal());
        //查看关联的用户信息;
        User user=order.getUser();
        System.out.println(user);
        //查看关联的商品信息
        List<Article> articles=order.getArticles();
        for (Article article:articles){
            System.out.println(article);
        }
    }
}
