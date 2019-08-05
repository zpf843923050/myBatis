package com.zpf.Test;


import com.zpf.factory.ZPFSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import javax.jws.soap.SOAPBinding;
import javax.swing.text.html.ObjectView;
import java.util.List;
import java.util.Map;


/**
 * 测试ResultType="map"
 */
public class SelectMapTest {
    public static void main(String[] args) {
        //获取Session实例
        SqlSession session = ZPFSqlSessionFactory.getSqlSession();
        //查询tb_user表中所有的数据返回list集合,每个元素是一个map
        List<Map<String, Object>> list
                = session.selectList("com.zpf.mapper.UserMapper.selectUserToMap");
        //遍历list集合，打印每一个Map对象
//        System.out.println(list);
        for (Map<String, Object> row : list) {

            System.out.println(row);
        }
        //提交事务
        session.commit();
        //关闭session
        session.close();

    }
}
