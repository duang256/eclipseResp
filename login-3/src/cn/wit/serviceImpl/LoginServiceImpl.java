package cn.wit.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wit.mapper.UsersMapper;
import cn.wit.pojo.Users;
import cn.wit.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService{
	@Resource
	private UsersMapper usersMapper;
	@Override
	public Users login(Users u) {
		return usersMapper.selByUsers(u);
	}
	
}
