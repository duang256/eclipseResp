package cn.wit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.wit.service.AirportService;
import cn.wit.serviceImpl.AirportServiceImpl;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	
		private AirportService airportService;
		@Override
		public void init() throws ServletException {
			ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
			airportService= ac.getBean("airportService",AirportServiceImpl.class);
		}
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setAttribute("list",airportService.selAll());
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}

	

}
