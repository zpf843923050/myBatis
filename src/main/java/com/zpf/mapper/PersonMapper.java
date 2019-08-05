package com.zpf.mapper;

import com.zpf.domain.Person;

public interface PersonMapper {

    /**
     * 根据ID查询Person,
     * 方法名和参数名必须和xml文件中的<select></select>元素的id和parameterType属性一致
     * @param id
     * @return Person对象
     */
    Person selectPersonById(Integer id);
}
