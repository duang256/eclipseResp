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
			//放行
			chain.doFilter(request, response);
		}else{
				boolean isExist=false;
				HttpSession session = req.getSession();
				//先判断属不属于有权限的uri
				List<Url> urlist = (List<Url>) session.getAttribute("urlist");
				if(urlist!=null){
					System.out.println("urlist不为空");
					for (Url url : urlist) {
						System.out.println(url+":"+uri);
						if(uri.equals(url.getName())){
							isExist=true;
						}
					}
					if(isExist){
						System.out.println("存在有权限的uri");
						//如果属于有权限的uri，判断是否是当前用户是否有访问该uri的权限
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
							//此时是uri属于权限，而且用户拥有该权限，放行
							System.out.println("有uri权限");
							chain.doFilter(request, response);
						}else{
							//此时uri属于权限，用户没该权限，无权限访问跳回登陆页面
							System.out.println("无uri权限");
							res.sendRedirect("/rbac/login.jsp");
						}
					}else{
						//此时是uri不属于权限，放行
						chain.doFilter(request, response);
					}
				}else{
					//此时该权限表里边没有数据，所有都放行
					chain.doFilter(request, response);
				}
				
			}
		}
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	

}
