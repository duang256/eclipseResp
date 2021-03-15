package cn.wit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor implements HandlerInterceptor{
	//在进入控制器之前执行
	//如果返回值false 阻止进入controller
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(arg2);
		System.out.println("preHandle");
		return true;
	}
	
	
	
	
	//controller执行完成之后，进入到jsp之前执行
	
	//日志记录
	//在jsp进行显示给用户之前，进行敏感词语过滤
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		//敏感词语过滤
		String word=arg3.getModel().get("model").toString();
		String newWord=word.replace("政治", "**");
		arg3.getModel().put("model", newWord);
		
		
		System.out.println("跳转到"+arg3.getViewName());
		//拿到controller中参数的值
		System.out.println("参数的值"+arg3.getModel().get("model"));
		//修改controller中参数的值
		System.out.println(arg3.getModel().put("model", "修改后的model"));
		// TODO Auto-generated method stub
		System.out.println("postHandle");
		
	}
	
	
	//jsp执行完之后执行
	
	//所有异常都会被手机在arg3中
	//记录在执行过程中出现的异常
	//可以把异常记录在日志中
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		//异常收集
		System.out.println("afterCompletion"+arg3.getMessage());
		
		System.out.println();
		System.out.println("afterCompletion");
		// TODO Auto-generated method stub
		
	}


}
