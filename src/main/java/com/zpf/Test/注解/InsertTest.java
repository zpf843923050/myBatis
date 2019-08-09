package com.zpf.Test.注解;

import com.zpf.domain.User;
import com.zpf.factory.ZPFSqlSessionFactory;
import com.zpf.mapper_2.UserMapper;
import org.apache.ibatis.session.SqlSession;
import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

import java.util.List;

public class InsertTest {
    public static void main(String[] args) {
        SqlSession session = ZPFSqlSessionFactory.getSqlSession();
//        testInsert(session);
//        testSelectUserById(session);
//        testDeleteUserById(session);
        testModifyUser(session);
        session.commit();
        session.close();
    }

    public static void testInsert(SqlSession session) {
        UserMapper um = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("zpf");
        user.setLoginname("doudou");
        user.setPassword("123455");
        user.setPhone("1221");
        um.SaveUser(user);

    }

    public static void testSelectUserById(SqlSession session) {
        UserMapper um = session.getMapper(UserMapper.class);
        User user = um.SelectUserById(1);
        System.out.println(user);
        System.out.println("查询所有 :");
        List<User> userList = um.SelectUsers();
        //显示所有用户
        for (User u : userList
        ) {
            System.out.println(u);
        }
    }
    public  static void testDeleteUserById(SqlSession session){
        UserMapper um = session.getMapper(UserMapper.class);
        um.RemoveUser(1);
    }
    public  static void testModifyUser(SqlSession session){
        UserMapper um = session.getMapper(UserMapper.class);
        User user=new User();
        user.setUsername("zz");
        user.setId(1);
        um.ModifyUser(user);
    }
}
