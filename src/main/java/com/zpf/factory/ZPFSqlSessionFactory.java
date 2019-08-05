package com.zpf.factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class ZPFSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory = null;

    //初始化创建sqlSessionFactory对象
    static {

        //读取mybatis-conf.xml配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-conf.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //获取SqlSession对象的静态方法
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    //获取SqlSessionFactory的静态方法
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
