package com.zpf.mapper;

import com.zpf.domain.Employee;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public interface EmployeeMapper {
    List<Employee> selectEmployeeByIdlike(HashMap<String, Object> params);

    List<Employee> selectEmployeeByLoginlike(HashMap<String, Object> params);

    List<Employee> selectEmployeeChoose(HashMap<String, Object> params);

    Employee selectEmployeeWithId(Integer id);

    void updateEmployeeIfNecessary(Employee employee);

    List<Employee> selectEmployeeIn(List<Integer> ids);

    //传入参数进行模糊查询
    List<Employee> selectEmployeeByLikeName(Employee employee);
}
