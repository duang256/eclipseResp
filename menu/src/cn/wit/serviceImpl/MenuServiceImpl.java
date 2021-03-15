package cn.wit.serviceImpl;

import java.util.List;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wit.mapper.MenuMapper;
import cn.wit.pojo.Menu;
import cn.wit.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
	/*
	 * 可以不在applicationContext中设置bean，用注解进行替换
	 * */
	@Resource
	private MenuMapper menuMapper;
	@Override
	public List<Menu> show() {
		return menuMapper.selByPid(0);
	}
	

}
