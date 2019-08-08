package com.zpf.Test;

import com.zpf.domain.Employee;
import com.zpf.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DynamicSQLTest {
    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-conf.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        testSelectEmployeeByIdlike(session);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        testSelectEmployeeByLoginlike(session);
        System.out.println("#################################1");
        testSelectEmployeeChoose(session);
        System.out.println("#################################2");
        testUpdateEmployeeIfNecessary(session);
        System.out.println("#################################3");
        testSelectEmployeeIn(session);
        System.out.println("#################################4");
        testSelectEmployeeByLikeName(session);
        session.commit();
        session.close();
    }

    public static void testSelectEmployeeByIdlike(SqlSession session) {
        //获取对象代理
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);
        //创建hashmap存储
        HashMap<String, Object> params = new HashMap<>();
//        设置id属性
        // params.put("id", 2);

        List<Employee> employees = em.selectEmployeeByIdlike(params);
        //查看结果
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }

    public static void testSelectEmployeeByLoginlike(SqlSession session) {
        //获取对象代理
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);
        //创建hashmap存储
        HashMap<String, Object> params = new HashMap<>();
//        设置id属性
        params.put("loginname", "jack");
        params.put("password", "123456");

        List<Employee> employees = em.selectEmployeeByLoginlike(params);
        //查看结果
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }

    public static void testSelectEmployeeChoose(SqlSession session) {
        //获取对象代理
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);
        //创建hashmap存储
        HashMap<String, Object> params = new HashMap<>();
//        设置id属性
//        params.put("id",2);第一种情况

//        params.put("loginname","jack");第二种情况
//        params.put("password","123456");

//        第三种情况不填 执行sex='男'
        List<Employee> employees = em.selectEmployeeChoose(params);
        //查看结果
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }


    public static void testUpdateEmployeeIfNecessary(SqlSession session) {
        //获取对象代理
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);
        //创建hashmap存储
        Employee employee = em.selectEmployeeWithId(2);
        //设置需要修改的属性
        employee.setLoginname("mary");
        employee.setPassword("1234567");
        employee.setName("马瑞");
        em.updateEmployeeIfNecessary(employee);
    }

    public static void testSelectEmployeeIn(SqlSession session) {
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);
        //创建list集合
        List<Integer> ids = new ArrayList<>();
        //往list里添加两个测试数据
        ids.add(2);
        ids.add(3);
        List<Employee> employeeList = em.selectEmployeeIn(ids);
        for (Employee e : employeeList
        ) {
            System.out.println(e);
        }

    }


    public static void testSelectEmployeeByLikeName(SqlSession session) {
        EmployeeMapper em = session.getMapper(EmployeeMapper.class);
//创建对象
        Employee employee = new Employee();
        //设置模糊查询参数
        employee.setName("o");
        List<Employee> employeeList=em.selectEmployeeByLikeName(employee);
        System.out.println(employeeList);
    }
}

