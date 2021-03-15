package cn.wit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cn.wit.pojo.Flower;
import cn.wit.service.FlowerService;
import cn.wit.serviceImpl.FlowerServiceImpl;

/**
 * Servlet implementation class FlowerServlet
 */
@WebServlet("/main")
public class FlowerServlet extends HttpServlet {
	Logger logger=Logger.getLogger(FlowerServlet.class);
	FlowerService flower=new FlowerServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String oper=req.getParameter("oper");
		if("select".equals(oper)){
			String str=req.getParameter("name");
			System.out.println(str);
			List<Flower> list = flower.sel(str);
			req.setAttribute("list", list);
			req.getRequestDispatcher("/sel.jsp").forward(req, resp);
		}else if("delete".equals(oper)){
			flower.delOne(req.getParameter("name"));
			resp.sendRedirect("/flower4/index.jsp");
		}else if("add".equals(oper)){
			String name=req.getParameter("name");
			double price=Double.parseDouble(req.getParameter("price"));
			String production=req.getParameter("production");
			flower.addOne(name, price, production);
			resp.sendRedirect("/flower4/index.jsp");
		}else{
			logger.debug("没有找到对应的操作符"+oper);
		}
		
	}
}
