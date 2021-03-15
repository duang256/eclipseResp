package cn.wit.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wit.pojo.Url;
import cn.wit.pojo.Users;

@WebFilter("/*")
public class UrlFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		String uri=req.getRequestURI();
		if(uri.endsWith(".js")||uri.endsWith(".css")||uri.endsWith(".jpg")||uri.endsWith(".png")){
			//����
			chain.doFilter(request, response);
		}else{
				boolean isExist=false;
				HttpSession session = req.getSession();
				//���ж�����������Ȩ�޵�uri
				List<Url> urlist = (List<Url>) session.getAttribute("urlist");
				if(urlist!=null){
					System.out.println("urlist��Ϊ��");
					for (Url url : urlist) {
						System.out.println(url+":"+uri);
						if(uri.equals(url.getName())){
							isExist=true;
						}
					}
					if(isExist){
						System.out.println("������Ȩ�޵�uri");
						//���������Ȩ�޵�uri���ж��Ƿ��ǵ�ǰ�û��Ƿ��з��ʸ�uri��Ȩ��
						Users user = (Users) session.getAttribute("user");
						List<Url> urls = user.getUrl();
						boolean isRight=false;
						for (Url url : urls) {
							System.out.println(uri+":"+url.getName());
							if(uri.equals(url.getName())){
								isRight=true;
							}
						}
						if(isRight){
							//��ʱ��uri����Ȩ�ޣ������û�ӵ�и�Ȩ�ޣ�����
							System.out.println("��uriȨ��");
							chain.doFilter(request, response);
						}else{
							//��ʱuri����Ȩ�ޣ��û�û��Ȩ�ޣ���Ȩ�޷������ص�½ҳ��
							System.out.println("��uriȨ��");
							res.sendRedirect("/rbac/login.jsp");
						}
					}else{
						//��ʱ��uri������Ȩ�ޣ�����
						chain.doFilter(request, response);
					}
				}else{
					//��ʱ��Ȩ�ޱ����û�����ݣ����ж�����
					chain.doFilter(request, response);
				}
				
			}
		}
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	

}
