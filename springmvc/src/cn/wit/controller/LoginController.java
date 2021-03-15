package cn.wit.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wit.pojo.User;
import cn.wit.service.LoginService;

@Controller
public class LoginController {
	@Resource
	private LoginService loginServiceImpl;
	//restful风格+视图解析器
	@RequestMapping("{page}")
	public String demo(@PathVariable("page")String page) {
		return page;
	}
	
	@RequestMapping("login")
	public String login(User user,HttpSession session){
		User u = loginServiceImpl.selLogin(user);
		if(u!=null){
			//跳转到main.jsp
			session.setAttribute("user", u);
			return "main";
		}else{
			return "redirect:/login.jsp";
		}
	}
	
	
}
