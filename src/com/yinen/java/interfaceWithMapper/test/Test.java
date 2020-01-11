package com.yinen.java.interfaceWithMapper.test;

import com.yinen.java.interfaceWithMapper.mapper.LogMapper;
import com.yinen.java.interfaceWithMapper.pojo.Log;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 陈迎仁(Yinen)
 * @create 2020-01-10 10:54
 */
public class Test {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis_interfaceWithMapper.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();

        /*
         * 接口,为什么能实例化?
         *
         * 需要给接口一个实例化对象.
         *
         * 使用的JDK的动态代理设计模式.
         * 面向接口的代理设计模式(必须有接口)
         *
         */
//        LogMapper logMapper=session.getMapper(LogMapper.class);
//        List<Log> logs=logMapper.selAll();
//        for(Log log:logs){
//            System.out.println(log);
//        }

        LogMapper logMapper = session.getMapper(LogMapper.class);
        List<Log> list = logMapper.selByAccInAccout("3", "1");
        for (Log log : list) {
            System.out.println(log);
        }
        session.close();
        System.out.println("程序执行结束");
    }
}
