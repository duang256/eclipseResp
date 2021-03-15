package cn.wit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.wit.pojo.Users;
import cn.wit.service.LoginService;
import cn.wit.serviceImpl.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private LoginService ls;
	@Override
	public void init() throws ServletException {
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ls= ac.getBean("loginServiceImpl",LoginServiceImpl.class);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String userName = req.getParameter("username");
		String passWord = req.getParameter("password");
		Users u=new Users();
		u.setPassWord(passWord);
		u.setUserName(userName);
		Users user = ls.Login(u);
		if(user!=null){
			resp.sendRedirect("/login-2/main.jsp");
		}else{
			resp.sendRedirect("/login-2/login.jsp");
		}
	}

}
