package cn.wit.controller;

import java.util.List;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wit.pojo.Car;
import cn.wit.pojo.Users;
import cn.wit.service.LoginService;

@Controller
public class LoginController {
	@Resource
	private LoginService loginServiceImpl;
	
	@RequestMapping("login")
	public String login(String username,String password,HttpServletRequest req){
		Users users = loginServiceImpl.login(new Users(username,password));
		if(users!=null){
			List<Car> cars = loginServiceImpl.cars(users.getRid());
			HttpSession session = req.getSession();
			session.setAttribute("cars", cars);
			return "redirect:/main.jsp";
		}else{
			return "redirect:/login.jsp?error=yes";
		}
		
	}
}
