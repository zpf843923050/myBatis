package com.zpf.Test;

import com.zpf.domain.Clazz;
import com.zpf.domain.Person;
import com.zpf.domain.Student;
import com.zpf.mapper.ClazzMapper;
import com.zpf.mapper.PersonMapper;
import com.zpf.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
        System.out.println("---------------------------");
        testSelectStudentByClazzId(session);
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
        System.out.println("测试一对多");
        System.out.println(clazz.getId() + " "+ clazz.getCode() + " "+clazz.getName());
        //查看clazz对象关联的学生信息
        List<Student> students = clazz.getStudents();
        for (Student stu : students)
            System.out.println(stu);
    }
    public static void testSelectStudentByClazzId(SqlSession session){
        // 测试多对一，查询学生Student（多）的时候级联查询 班级Clazz（一）
        System.out.println("测试多对一");
        //获得ClazzMapper接口的代理对象
        StudentMapper sm = session.getMapper(StudentMapper.class);
        Student students=sm.selectStudentById(1);
        System.out.println(students);
        System.out.println(students.getClazz());
    }
}
