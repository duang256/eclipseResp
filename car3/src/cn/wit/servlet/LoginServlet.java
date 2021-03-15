package cn.wit.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.wit.pojo.Car;
import cn.wit.pojo.Users;
import cn.wit.service.LoginService;
import cn.wit.serviceImpl.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	LoginService  ls;
	@Override
	public void init() throws ServletException {
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ls= ac.getBean("loginServiceImpl",LoginServiceImpl.class);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Users users=new Users(username,password);
		Users login = ls.login(users);
		if(login!=null){
			List<Car> cars = ls.getCars(login.getRid());
			System.out.println(cars);
			HttpSession session = req.getSession();
			session.setAttribute("cars", cars);
			resp.sendRedirect("/car3/main.jsp");
		}else{
			resp.sendRedirect("/car3/login.jsp?error=yes");
		}
		
		
		
		
	}

}
