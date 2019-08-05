package com.zpf.Test;

import com.zpf.domain.Person;
import com.zpf.mapper.PersonMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

import java.io.IOException;
import java.io.InputStream;

public class OneToOneTest {
    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream inputStream= Resources.getResourceAsStream("mybatis-conf.xml");
        //初始化mybatis,创建SqlSessionFactory实例
        SqlSessionFactory sqlSessionFactory=  new SqlSessionFactoryBuilder().build(inputStream);
        //创建session实例
        SqlSession session=sqlSessionFactory.openSession();
        //获取Mapper接口的代理对象
        PersonMapper pm=session.getMapper(PersonMapper.class);
        //直接调用接口的方法,查询id为1的Person对象
        Person person =pm.selectPersonById(1);
        //提交事务
        System.out.println(person);
        System.out.println(person.getCard());
        session.commit();
        session.close();
    }
}
