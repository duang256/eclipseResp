package cn.wit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		
		
	String uri = req.getRequestURI();
	if(uri.equals("/springmvc/login")){
		return true;
	}	
	else{
		Object object = req.getSession().getAttribute("user");
		if(object!=null){
			return true;
		}
		res.sendRedirect("/springmvc/login.jsp");
		return false;
	}
	}
	
	
	//jsp֮ǰ
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

}
