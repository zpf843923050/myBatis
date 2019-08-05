package com.zpf.Test;

import com.zpf.factory.ZPFSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

public class DeleteTest {
    public static void main(String[] args) {
        //获取session实例
        SqlSession session = ZPFSqlSessionFactory.getSqlSession();
        session.delete("com.zpf.mapper.UserMapper.removeUser", 1);
        //提交事务
        session.commit();
        //关闭事务
        session.close();
    }
}
