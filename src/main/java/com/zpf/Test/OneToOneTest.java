package com.zpf.Test;

import com.zpf.domain.Clazz;
import com.zpf.domain.Person;
import com.zpf.mapper.ClazzMapper;
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
        InputStream inputStream = Resources.getResourceAsStream("mybatis-conf.xml");
        //初始化mybatis,创建SqlSessionFactory实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建session实例
        SqlSession session = sqlSessionFactory.openSession();
        //获取Mapper接口的代理对象
        PersonMapper pm = session.getMapper(PersonMapper.class);
        //直接调用接口的方法,查询id为1的Person对象
        Person person = pm.selectPersonById(1);
        //提交事务
        System.out.println(person);
        System.out.println(person.getCard());
        testSelectClazzById(session);
        session.commit();
        session.close();
    }

    /**
     * 测试一对多,班级查询Clazz(一)的时候级联查询学生Student（多）
     *
     * @param session
     */
    public static void testSelectClazzById(SqlSession session) {
        //获得ClazzMapper接口的代理对象
        ClazzMapper cm = session.getMapper(ClazzMapper.class);
        //调用selectClazzById方法
        Clazz clazz = cm.selectClazzById(1);
        //查看查询到的Clazz对象信息
        System.out.println(clazz.getId()+clazz.getCode()+clazz.getName());
    }
}
