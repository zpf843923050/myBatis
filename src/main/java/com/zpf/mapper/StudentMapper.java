package com.zpf.mapper;

import com.zpf.domain.Student;

public interface StudentMapper {
    //根据id 查询学生信息
    Student selectStudentById(Integer id);
}
