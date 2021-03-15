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
	 * �˴������಻Ҫ������service������
	 * ����serice������һ�ξͻᴴ��һ������
	 * �������������GCƵ������
	 */
     private FlowerService flowerService=new FlowerServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		List<Flower>list=flowerService.show();
		//��list���ݷ���request�У�����ת������������ת
		req.setAttribute("list", list);
		//����dao��service�����Ƿ���ת��servlet��
		if(list==null){
			System.out.println("listΪ��");
		}else{
			System.out.println("list��Ϊ��");
		}
		//��ǰ��ҳ����getAttribute��listȡ��������list����չʾ
		req.getRequestDispatcher("index.jsp").forward(req, resp);

	}

}
