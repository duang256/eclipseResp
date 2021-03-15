package cn.wit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wit.pojo.Car;
import cn.wit.service.LoginService;
import cn.wit.serviceImpl.LoginServiceImpl;

/**
 * Servlet implementation class LoginServler
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	LoginService loginService=new LoginServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		System.out.println(name);
		Car car = loginService.login(new Car(name));
		req.setAttribute("car", car);
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

}
