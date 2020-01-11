package com.yinen.java.flower.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.yinen.java.flower.pojo.Flower;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	public static void main(String[] args) throws IOException {
		//加载配置文件
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		//使用工厂设计模式
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//生产SqlSession
		SqlSession session=factory.openSession();

		//com.yinen.java.flower.mapper.FlowerMapper.selAll 是指xml文件中对应的方法的全路径
		List<Flower> list = session.selectList("com.yinen.java.flower.mapper.FlowerMapper.selAll");
		for (Flower flower : list) {
			System.out.println(flower.toString());
		}
		//返回一个记录或者变量
		int count = session.selectOne("com.yinen.java.flower.mapper.FlowerMapper.selById");
		System.out.println(count);

		//把数据库中哪个列的值当作map的key，例如name
		Map<Object, Object> map = session.selectMap("com.yinen.java.flower.mapper.FlowerMapper.selByMap", "name");
		System.out.println(map);
		session.close();
	}
}
