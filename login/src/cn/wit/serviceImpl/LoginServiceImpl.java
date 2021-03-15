package cn.wit.serviceImpl;

import cn.wit.mapper.UsersMapper;
import cn.wit.pojo.Users;
import cn.wit.service.LoginService;

public class LoginServiceImpl implements LoginService{
	private  UsersMapper usersMapper;
	
	

	public UsersMapper getUsersMapper() {
		return usersMapper;
	}



	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}



	@Override
	public Users login(Users u) {
		if(usersMapper.selOne(u)==null){
			System.out.println("null");
		}
		return usersMapper.selOne(u);
	}

}
