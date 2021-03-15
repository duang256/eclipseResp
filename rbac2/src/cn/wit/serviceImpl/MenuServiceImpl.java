package cn.wit.serviceImpl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wit.mapper.MenuMapper;
import cn.wit.pojo.Menu;
import cn.wit.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Resource
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> showMenu(int rid) {
		return menuMapper.selByRid(rid, 0);
	}

}
