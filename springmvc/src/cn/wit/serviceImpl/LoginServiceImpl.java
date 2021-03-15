package cn.wit.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wit.mapper.LoginMapper;
import cn.wit.pojo.User;
import cn.wit.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	@Resource
	private LoginMapper loginMapper;
	@Override
	public User selLogin(User user) {
		return loginMapper.selByUser(user);
	}

}
