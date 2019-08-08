package com.zpf.Test;

import com.zpf.domain.UserDemo;
import com.zpf.factory.ZPFSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

public class SelectTest {
    public static void main(String[] args) {
        SqlSession session = ZPFSqlSessionFactory.getSqlSession();
        UserDemo userDemo = session.selectOne("com.zpf.mapper.UserMapper.selectUser", 1);
        System.out.println("结果:"+ userDemo);
        session.commit();
        session.close();
    }
}
