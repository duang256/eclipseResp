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
	/**
	 * 此处创建类不要创建在service方法中
	 * 否则serice被调用一次就会创建一个对象
	 * 创建多个对象导致GC频繁回收
	 */
     private FlowerService flowerService=new FlowerServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		List<Flower>list=flowerService.show();
		//将list数据放在request中，请求转发进行数据流转
		req.setAttribute("list", list);
		//测试dao、service数据是否流转到servlet中
		if(list==null){
			System.out.println("list为空");
		}else{
			System.out.println("list不为空");
		}
		//在前端页面用getAttribute将list取出来，对list进行展示
		req.getRequestDispatcher("index.jsp").forward(req, resp);

	}

}
