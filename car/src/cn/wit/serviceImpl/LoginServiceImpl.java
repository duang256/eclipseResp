package cn.wit.serviceImpl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.wit.mapper.CarMapper;
import cn.wit.pojo.Car;
import cn.wit.service.LoginService;

public class LoginServiceImpl implements LoginService{

	@Override
	public Car login(Car car) throws IOException {
		//����mybatis�����ļ�
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		
		//�õ�mapper����
		CarMapper mapper = session.getMapper(CarMapper.class);
		Car selCar = mapper.selCar(car);
		return selCar;
	}

}
