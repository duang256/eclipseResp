package cn.wit.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wit.mapper.CarMapper;
import cn.wit.mapper.UsersMapper;
import cn.wit.pojo.Car;
import cn.wit.pojo.Users;
import cn.wit.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService{
	
	@Resource
	private CarMapper carMapper;
	@Resource
	private UsersMapper usersMapper;
	
	
	@Override
	public Users login(Users users) {
		
		return usersMapper.selUsers(users);
	}

	@Override
	public List<Car> cars(int rid) {
		// TODO Auto-generated method stub
		return carMapper.selCar(rid);
	}
	
}
