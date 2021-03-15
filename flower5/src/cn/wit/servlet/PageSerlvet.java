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
			//·��
				//���·�� 
					//����һ���ļ����г���
				//����·��
					//��̬��Դ����̬��Դ����webcontent�У�д����·��Ӧ����/��Ŀ��/webcontent��·��
					//����ת������Ŀ�³���  /page.jsp  
					//д��ľ���·��ʱ�Ǵ�src�³���
			req.getRequestDispatcher("/page.jsp").forward(req, resp);
		}
	}

}
