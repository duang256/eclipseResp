package cn.wit.controller;

import java.util.List;



import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wit.pojo.Menu;
import cn.wit.service.MenuService;

@Controller
public class MenuController {
	
	@Resource
	private MenuService menuServiceImpl;
	
	@RequestMapping("show")
	@ResponseBody
	public List<Menu>show(){
		return menuServiceImpl.show();
	}
	
	
}
