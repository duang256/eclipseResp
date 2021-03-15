package cn.wit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import cn.wit.pojo.Car;
import cn.wit.pojo.Users;
import cn.wit.service.LoginService;
import cn.wit.serviceImpl.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	LoginService loginService=new LoginServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置浏览器响应编码格式
		req.setCharacterEncoding("utf-8");
		//完成认证
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username+":"+password);
		Users users=new Users(username,password);
		Users u= loginService.login(users);
		System.out.println(u);
		
		//如果认证成功，则进行授权操作
		//如果认证失败，则 error设为yes回到登录界面弹框密码错误
		if(u!=null){
			List<Car> cars=loginService.getCars(u);
			System.out.println(cars);
			//登录操作不适合用请求转发，所以用session来传参
			HttpSession session = req.getSession();
			session.setAttribute("cars", cars);
			resp.sendRedirect("/car2/main.jsp");
		}else{
			resp.sendRedirect("/car2/login.jsp?error=yes");
		}
	}
}
