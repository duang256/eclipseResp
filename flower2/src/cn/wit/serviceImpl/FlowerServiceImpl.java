package cn.wit.serviceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import cn.wit.pojo.Flower;
import cn.wit.service.FlowerService;

public class FlowerServiceImpl implements FlowerService{

	@Override
	public List<Flower> selAll() throws Exception {
		
		/*InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();*/
		
		InputStream resourceAsStream = Resources.getResourceAsStream("flower.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession openSession = factory.openSession();
		List<Flower> list = openSession.selectList("cn.wit.mapper.FlowerMapper.selAll");
		openSession.close();
		
		return list;
	}

}
