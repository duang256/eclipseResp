package cn.wit.serviceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.wit.mapper.FlowerMapper;
import cn.wit.pojo.Flower;
import cn.wit.servie.FlowerService;

public class FlowerServiceImpl implements FlowerService{

	@Override
	public List<Flower> show() throws IOException {
		//解析配置文件
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		//创建工厂
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		FlowerMapper mapper = session.getMapper(FlowerMapper.class);
		List<Flower> list = mapper.selAll();
		return list;
	}

}
