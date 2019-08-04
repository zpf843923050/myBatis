package com.zpf.Test;

import com.zpf.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        //读取mybatis-config.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-conf.xml");
        //初始化mybatis,创建SqlSessionFactory类的实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建session实例
        SqlSession session=sqlSessionFactory.openSession();
        //创建User对3象
        User user =new User("a","男",22);
        //插入数据
        session.insert("com.zpf.mapper.UserMapper.save",user);
        //提交事务
        session.commit();
        //关闭session
        session.close();
    }
}

