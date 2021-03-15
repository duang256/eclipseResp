package cn.wit.serviceImpl;

import cn.wit.mapper.UsersMapper;
import cn.wit.pojo.Users;
import cn.wit.service.UsersService;

public class UsersServiceImpl implements UsersService {
	private UsersMapper usersMapper;

	public UsersMapper getUsersMapper() {
		return usersMapper;
	}
	
	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}

	@Override
	public Users login(Users users) {
		
		return usersMapper.selByUsers(users);
	}
	

}
