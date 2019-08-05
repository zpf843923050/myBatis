package com.zpf.Test;

import com.zpf.domain.User;
import com.zpf.factory.ZPFSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 通过Mapper文件中的映射关系<ResultMap></ResultMap> 与POJO对象的属性进行映射
 */
public class ResultMapTest {
    public static void main(String[] args) {
        //获取Session实例
        SqlSession session = ZPFSqlSessionFactory.getSqlSession();
        List<User> user_list
                = session.selectList("com.zpf.mapper.UserMapper.selectUserMap");
        //遍历user_list
        for (User user : user_list) {
            System.out.println(user);
        }
        session.commit();
        session.close();
    }
}
