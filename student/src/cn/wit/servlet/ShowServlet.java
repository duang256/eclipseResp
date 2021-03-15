package cn.wit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wit.pojo.PageInfo;
import cn.wit.service.StudentService;
import cn.wit.serviceimpl.StudentServiceImpl;

@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	private StudentService stuService = new StudentServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageSize = req.getParameter("pageSize");
		String pageNumber = req.getParameter("pageNumber");
		PageInfo pi = stuService.showPage(pageSize, pageNumber);
		req.setAttribute("pi", pi);
		req.getRequestDispatcher("page.jsp").forward(req, resp);
	}
}
