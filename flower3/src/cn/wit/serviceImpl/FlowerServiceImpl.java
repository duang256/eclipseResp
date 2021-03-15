package cn.wit.serviceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import cn.wit.pojo.Flower;
import cn.wit.service.FlowerService;

public class FlowerServiceImpl implements FlowerService{

	@Override
	public List<Flower> selAll() throws IOException {
		//用这三行衔接dao和service，之前用接口实现的
		InputStream is=Resources.getResourceAsStream("flower.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		
		
		List<Flower>list=session.selectList("flower.selAll");
		session.close();
		return list;
		
		
	}

}
