package com.zpf.Test;

import com.zpf.domain.User;
import com.zpf.factory.ZPFSqlSessionFactory;
import com.zpf.mapper_2.UserMapper;
import org.apache.ibatis.session.SqlSession;

public class TestOneLevelCache {
    public static void main(String[] args) {
        TestOneLevelCache t = new TestOneLevelCache();
//        t.testCache1();
        t.testCache2();
    }

    /**
     * 一级缓存:session级别的缓存，默认开启
     */
    public void testCache1() {
        //使用工厂类来获取SqlSession对象
        SqlSession session = ZPFSqlSessionFactory.getSqlSession();
        //获得UserMapper对象
        UserMapper um = session.getMapper(UserMapper.class);
        //查询id为1的User对象.会执行SELECT语句
        User user = um.selectUser2ById(2);
        System.out.println(user);
        //再次查询id为1的User对象,因为是一个SqlSession所以会从以前的一级缓存中查找数据
        User user2 = um.selectUser2ById(2);
        System.out.println(user2);
        //关闭SqlSession对象
        session.close();
    }

    public void testCache2() {
        //工厂类
        SqlSession session = ZPFSqlSessionFactory.getSqlSession();
        UserMapper um = session.getMapper(UserMapper.class);
        User user = um.selectUser2ById(2);
        System.out.println(user);
        um.deleteUserById(3);
        session.commit();
        //再次查询id为2的对象,因为DML操作会清空SqlSession缓存,所以再次执行SELECT语句
        User user2 = um.selectUser2ById(2);
        System.out.println(user2);
        //关闭
        session.close();
    }
}
