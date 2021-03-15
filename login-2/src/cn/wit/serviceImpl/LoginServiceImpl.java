package cn.wit.serviceImpl;

import cn.wit.mapper.UsersMapper;
import cn.wit.pojo.Users;
import cn.wit.service.LoginService;

public class LoginServiceImpl implements LoginService{
	private UsersMapper usersMapper;

	public UsersMapper getUsersMapper() {
		return usersMapper;
	}

	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}

	@Override
	public Users Login(Users u) {
		return usersMapper.selByUsers(u);
	}
	
}
