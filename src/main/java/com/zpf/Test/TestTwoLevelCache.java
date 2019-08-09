package com.zpf.Test;

import com.zpf.domain.User;
import com.zpf.factory.ZPFSqlSessionFactory;
import com.zpf.mapper_2.UserMapper;
import org.apache.ibatis.session.SqlSession;

public class TestTwoLevelCache {
    public static void main(String[] args) {
        TestTwoLevelCache t = new TestTwoLevelCache();
        t.testCache1();
    }

    public void testCache1() {
        SqlSession session = ZPFSqlSessionFactory.getSqlSession();
        UserMapper um = session.getMapper(UserMapper.class);
        User user = um.selectUser2ById(1);
        System.out.println(user);
        //执行delete操作
        um.deleteUserById(2);
        session.commit();
        //再次查询ID为1的User对象,因为dml操作会清空SqlSession的缓存,所以再次执行select语句
        User user2 = um.selectUser2ById(1);
        System.out.println(user2);
        session.close();
    }
}
