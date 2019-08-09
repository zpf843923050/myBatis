package com.zpf.mapper_2;

import com.zpf.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    User selectUserById(int id);

    //根据id查询user
    User selectUser2ById(int id);

    //查询所有user
    List<User> selectAllUser();

    //根据id删除user
    void deleteUserById(int id);

    //以下注解配置
    @Insert("INSERT INTO tb_user(username,loginname,PASSWORD,phone)values (#{username},#{loginname},#{password},#{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int SaveUser(User user);

    @Delete("DELETE FROM tb_user WHERE id=#{id}")
    int RemoveUser(@Param("id") Integer id);

    @Update("update tb_user set username =#{username} where id=#{id}")
    void ModifyUser(User user);

    @Select("select *from tb_user where id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "loginname", property = "loginname"),
            @Result(column = "password", property = "password"),
            @Result(column = "phone", property = "phone")
    })
    User SelectUserById(Integer id);

    @Select("SELECT *FROM tb_user")
    List<User> SelectUsers();
}
