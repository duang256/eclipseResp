package cn.wit.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wit.mapper.UsersMapper;
import cn.wit.pojo.Users;
import cn.wit.service.ElementService;
import cn.wit.service.MenuService;
import cn.wit.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Resource
	private UsersMapper usersMapper;
	@Resource
	private MenuService menuServiceImpl;
	@Resource
	private ElementService elementServiceImpl;
	
	@Override
	public Users login(Users users) {
		Users user = usersMapper.selByUser(users);
		if(user!=null){
			user.setMenus(menuServiceImpl.showMenu(user.getRid()));
			user.setElements(elementServiceImpl.selByRid(user.getRid()));
		}
		return user;
	}

}
