package com.zpf.Test.注解;

import com.zpf.domain.Person;
import com.zpf.factory.ZPFSqlSessionFactory;
import com.zpf.mapper3.PersonMapper;
import org.apache.ibatis.session.SqlSession;
//注意配置   <package name="com.iot.mybatis.mapper"/>配置 否则扫描不到接口
public class OneToOne {
    public static void main(String[] args) {
        SqlSession session = ZPFSqlSessionFactory.getSqlSession();
        testSelectPersonById(session);
        session.commit();
        session.close();

    }

    public static void testSelectPersonById(SqlSession session) {
        PersonMapper pm = session.getMapper(PersonMapper.class);
        Person person = pm.SelectPersonById(1);
        System.out.println(person);
        System.out.println(person.getCard());
    }
}
