package cn.wit.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wit.pojo.Url;
import cn.wit.pojo.Users;
import cn.wit.service.UrlService;
import cn.wit.service.UsersService;

@Controller
public class UsersController {
	
	@Resource
	private UrlService urlServiceImpl;
	
	@Resource
	private UsersService usersServiceImpl;
	
	@RequestMapping("login")
	public String login(Users users,HttpSession session){
		
		Users user = usersServiceImpl.login(users);
		if(user!=null){
			System.out.println(user);
			List<Url> urlist=urlServiceImpl.showAll();
			session.setAttribute("user", user);
			session.setAttribute("urlist", urlist);
			return "redirect:/main.jsp";
		}
		return "redirect:/login.jsp";
	}
	
	
	@RequestMapping("demo")
	public String demo(){
		return "/a.jsp";
	}
}
