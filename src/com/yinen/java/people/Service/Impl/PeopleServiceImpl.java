package com.yinen.java.people.Service.Impl;

import com.yinen.java.people.Service.PeopleService;
import com.yinen.java.people.pojo.People;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 陈迎仁(Yinen)
 * @create 2020-01-05 10:00
 */
public class PeopleServiceImpl implements PeopleService {
    /*
        方法功能：显示全部人员信息
        参数：无
        描述：返回值为一个List;在数据访问层处理异常和在控制器中处理异常,service中只抛出异常.
    */
    @Override
    public List<People> show() throws IOException {
        InputStream is=Resources.getResourceAsStream("mybatis_people.xml");
        //前面是工厂       实例化工厂对象时使用的是  构建者设计模式   名称标志:后面有Builder
        //构建者设计模式意义: 简化对象实例化过程
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        List<People> list = session.selectList("com.yinen.java.people.mapper.PeopleMapper.selAll");
        session.close();
        return list;
    }
}
