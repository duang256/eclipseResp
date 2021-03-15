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
		//�����������Ӧ�����ʽ
		req.setCharacterEncoding("utf-8");
		//�����֤
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username+":"+password);
		Users users=new Users(username,password);
		Users u= loginService.login(users);
		System.out.println(u);
		
		//�����֤�ɹ����������Ȩ����
		//�����֤ʧ�ܣ��� error��Ϊyes�ص���¼���浯���������
		if(u!=null){
			List<Car> cars=loginService.getCars(u);
			System.out.println(cars);
			//��¼�������ʺ�������ת����������session������
			HttpSession session = req.getSession();
			session.setAttribute("cars", cars);
			resp.sendRedirect("/car2/main.jsp");
		}else{
			resp.sendRedirect("/car2/login.jsp?error=yes");
		}
	}
}
