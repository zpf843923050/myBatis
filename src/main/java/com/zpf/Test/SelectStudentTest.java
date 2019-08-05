package com.zpf.Test;

import com.zpf.domain.Student;
import com.zpf.factory.ZPFSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SelectStudentTest {
    public static void main(String[] args) {
        //获取session实例
        SqlSession session = ZPFSqlSessionFactory.getSqlSession();
        List<Student> students = session.selectList("com.zpf.mapper.UserMapper.selectStudent");
        for (Student student:students)
        {
            System.out.println(student);
        }
        session.commit();
        session.close();
    }
}
