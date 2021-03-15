package cn.wit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wit.dao.Impl.FlowerDaoImpl;
import cn.wit.pojo.Flower;
import cn.wit.service.FlowerService;
import cn.wit.serviceImpl.FlowerServiceImpl;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
      private FlowerService flowerService=new FlowerServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//设置请求、响应编码格式
    	req.setCharacterEncoding("utf-8");
    	resp.setContentType("text/html;charset=utf-8");
    	//拿到表单数据，传递flower给逻辑层
    	String name=req.getParameter("name");
    	double price=Double.parseDouble(req.getParameter("price"));
    	String production=req.getParameter("production");
    	Flower flower=new Flower();
    	flower.setName(name);
    	flower.setPrice(price);
    	flower.setProduction(production);
    	int i=flowerService.add(flower);
    	if(i>0){
    		resp.sendRedirect("show");
    	}else{
    		resp.sendRedirect("add.jsp");
    	}
    	
    }

}
