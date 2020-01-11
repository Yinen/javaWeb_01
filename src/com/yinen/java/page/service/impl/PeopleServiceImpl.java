package com.yinen.java.page.service.impl;

import com.yinen.java.page.pojo.PageInfo;
import com.yinen.java.page.service.PeopleService;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈迎仁(Yinen)
 * @create 2020-01-07 15:42
 */
public class PeopleServiceImpl implements PeopleService  {
    @Override
    public PageInfo showPage(int pageSize, int pageNum)throws IOException {
        InputStream is=Resources.getResourceAsStream("mybatis_page.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=factory.openSession();

        PageInfo pi=new PageInfo();
        pi.setPageNumber(pageNum);
        pi.setPageSize(pageSize);
        Map<String,Object> map=new HashMap<>();
        map.put("pageSize",pageSize);
        map.put("pageStart",pageSize*(pageNum-1));
        pi.setList(session.selectList("com.yinen.java.page.mapper.PeopleMapper.selByPage",map));
        //总条数
        long count = session.selectOne("com.yinen.java.page.mapper.PeopleMapper.selCount");

        pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);

        return pi;
    }
}
