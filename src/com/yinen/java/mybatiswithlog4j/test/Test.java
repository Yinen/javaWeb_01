package com.yinen.java.mybatiswithlog4j.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yinen.java.mybatiswithlog4j.pojo.People;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Test {
	public static void main(String[] args) throws IOException {
		//获取Session
		InputStream is = Resources.getResourceAsStream("mybatis_log4j.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();

		/*
		    测试mybatis运用log4j后的日志输出（全局文件中settings标签设置）以及局部日志的输出
		*/
//		session.selectList("com.yinen.java.mybatiswithlog4j.mapper.PeopleMapper.selAll");
//		session.selectList("com.yinen.java.mybatiswithlog4j.mapper.PeopleMapper.selById");
//		session.selectList("com.yinen.java.mybatiswithlog4j.mapper.PeopleMapper2.selAll");
//		session.selectList("com.yinen.java.mybatiswithlog4j.mapper.PeopleMapper2.selById");

		/*
		    测试mybatis运用含参数的查询，注意Mapper文件地配置
		*/
////		测试数值型参数
//		People p=session.selectOne("com.yinen.java.mybatiswithlog4j.mapper.PeopleMapper.selById",1);
//		System.out.println(p);
////		测试map型参数
//		Map<String,Object> map=new HashMap<>();
//		map.put("id",1);
//		map.put("name","张三");
//		People pp=session.selectOne("com.yinen.java.mybatiswithlog4j.mapper.PeopleMapper.selByIdName",map);
//		System.out.println(pp);
////		测试${}型的参数，使用对象
//		People po=new People();
//		po.setId(2);
//		People ppp=session.selectOne("com.yinen.java.mybatiswithlog4j.mapper.PeopleMapper.selByObject",po);
//		System.out.println(ppp);
////		测试含有<![CDATA[.......]]>来处理包含了<这类字符的查询语句
//		List<People> pppp=session.selectList("com.yinen.java.mybatiswithlog4j.mapper.PeopleMapper.test",3);
//		System.out.println(pppp);


		/*
		    测试分页功能
		    测试了别名，注意全局文件地配置以及mapper文件中的变化
		*/
//		int pageSize=2,pageNum=2;
//		Map<String,Object> map=new HashMap<>();
//		map.put("pageSize",pageSize);
//		map.put("pageStart",pageSize*(pageNum-1));
//		List<People> ppppp=session.selectList("com.yinen.java.mybatiswithlog4j.mapper.PeopleMapper.splitPage",map);
//		System.out.println("分页：   "+ppppp);

		/*
		    测试添加功能
		*/
		People p1=new People();
		p1.setName("add1");
		p1.setAge(50);
		try{
			int index1=session.insert("com.yinen.java.mybatiswithlog4j.mapper.PeopleMapper.ins",p1);
			if (index1>0){
				System.out.println("成功");
			}
			else{
				System.out.println("失败");
			}
		}catch(Exception e){
			session.rollback();
		}

		People p2=new People();
		p2.setName("add2");
		p2.setAge(51);
		try{
			int index2=session.insert("com.yinen.java.mybatiswithlog4j.mapper.PeopleMapper.ins",p2);
			if (index2>0){
				System.out.println("成功");
			}
			else{
				System.out.println("失败");
			}
		}catch(Exception e){
			session.rollback();
		}
		//增删改一定要commit一下
		session.commit();










		//关闭session
		session.close();

	}
}
