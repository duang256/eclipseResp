package cn.wit.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wit.mapper.UsersMapper;
import cn.wit.pojo.Users;
import cn.wit.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	@Resource
	private UsersMapper usersMapper;  
	@Override
	public int insRegister(Users users) {
		return usersMapper.insUsers(users); 
	}
	
}
