package com.zpf.Test;

import com.zpf.domain.Clazz;
import com.zpf.domain.Student;
import com.zpf.factory.ZPFSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SelectClazzTest {
    public static void main(String[] args) {
        SqlSession session = ZPFSqlSessionFactory.getSqlSession();
        List<Clazz> clazz_list=session.selectList("com.zpf.mapper.UserMapper.selectClazz");
        for (Clazz clazz:clazz_list){
            System.out.println(clazz);
            List<Student> student_list=clazz.getStudents();
            for (Student student:student_list){
                System.out.println("["+student.getId()+", "+student.getSex()+","+student.getName()+","+student.getAge()+"]");

            }

        }
        session.commit();
        session.close();
    }
}
