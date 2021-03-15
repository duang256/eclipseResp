package cn.wit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wit.pojo.Flower;
import cn.wit.pojo.PageInfo;
import cn.wit.service.FlowerService;
import cn.wit.serviceImpl.FlowerServiceImpl;

/**
 * Servlet implementation class PageSerlvet
 */
@WebServlet("/page")
public class PageSerlvet extends HttpServlet {
	FlowerService fs=new FlowerServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageNumber=req.getParameter("pageNumber");
		String pageSize=req.getParameter("pageSize");
		PageInfo pi = fs.selByPage(pageNumber, pageSize);
		if(pi!=null){
			req.setAttribute("pi", pi);
			//路径
				//相对路径 
					//从上一个文件夹中出发
				//绝对路径
					//静态资源，静态资源都在webcontent中，写绝对路径应该是/项目名/webcontent中路径
					//请求转发从项目下出发  /page.jsp  
					//写类的绝对路径时是从src下出发
			req.getRequestDispatcher("/page.jsp").forward(req, resp);
		}
	}

}
