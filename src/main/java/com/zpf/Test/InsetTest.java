package com.zpf.Test;

import com.zpf.domain.UserDemo;
import com.zpf.factory.ZPFSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

public class InsetTest {
    public static void main(String[] args) {
        SqlSession session= ZPFSqlSessionFactory.getSqlSession();
        //创建User对象
        UserDemo userDemo =new UserDemo("zpf","男",22);
        //插入数据
        session.insert("com.zpf.mapper.UserMapper.saveUser", userDemo);
        //提交事务
        session.commit();
        //关闭session
        session.close();
    }
}
