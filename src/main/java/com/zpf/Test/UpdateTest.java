package com.zpf.Test;

import com.zpf.domain.User;
import com.zpf.factory.ZPFSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

public class UpdateTest {
    public static void main(String[] args) {
        //获取session实例
        SqlSession session= ZPFSqlSessionFactory.getSqlSession();
        //根据id查询User对象
        User user=session.selectOne("com.zpf.mapper.UserMapper.selectUser",1);
        //修改User对象的属性值
        user.setNAME("tom");
        user.setAGE(25);
        //修改User对象
        session.update("com.zpf.mapper.UserMapper.modifyUser",user);
        session.commit();
        session.close();
    }
}
