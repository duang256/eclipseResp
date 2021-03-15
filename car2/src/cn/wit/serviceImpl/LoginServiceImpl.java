package cn.wit.serviceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.wit.mapper.CarMapper;
import cn.wit.mapper.UsersMapper;
import cn.wit.pojo.Car;
import cn.wit.pojo.Users;
import cn.wit.service.LoginService;

public class LoginServiceImpl implements LoginService{
	
	@Override
	public Users login(Users users) throws IOException {
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();	
		UsersMapper usersMapper = session.getMapper(UsersMapper.class);
	
		return usersMapper.selUsers(users);
	}

	@Override
	public List<Car> getCars(Users users) throws IOException {
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();	
		CarMapper carMapper = session.getMapper(CarMapper.class);
		
		return carMapper.selCar(users);
		
	}

}
