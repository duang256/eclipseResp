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
	UsersMapper usersMapper;
	@Resource
	CarMapper carMapper;
	
	@Override
	public Users login(Users users) {
		return usersMapper.selByUsers(users);
	}

	@Override
	public List<Car> getCars(int rid) {
		return carMapper.selCars(rid);
	}
	
}
