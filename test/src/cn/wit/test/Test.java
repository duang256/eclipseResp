package cn.wit.test;

import java.io.IOException;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import cn.wit.pojo.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	public static void main(String[] args) throws IOException {
		//测试专用
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		
		
		
		//selectList用于查询返回  类list
		List<Flower> list=session.selectList("flower.selAll");
		for (Flower flower : list) {
			System.out.println(flower.toString());
		}
		
		//select
		int count= session.selectOne("flower.selOne");
		System.out.println(count);
		
		//把数据库中某个值当做map的key
		Map<Object,Object>map=session.selectMap("flower.c", "name");
		System.out.println(map);
		
		session.close();
	}

}
