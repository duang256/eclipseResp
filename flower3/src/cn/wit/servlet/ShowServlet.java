package cn.wit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wit.pojo.Flower;
import cn.wit.service.FlowerService;
import cn.wit.serviceImpl.FlowerServiceImpl;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FlowerService flower=new FlowerServiceImpl();
		List <Flower>list=flower.selAll();
		req.setCharacterEncoding("utf-8");
		req.setAttribute("list", list);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
	}

}
