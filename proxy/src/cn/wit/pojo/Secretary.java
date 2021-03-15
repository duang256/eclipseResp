package cn.wit.pojo;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Secretary implements MethodInterceptor{

	//arg0是子类对象
	//arg1真实对象的方法
	//agr2参数
	//arg3子类生成的代理方法
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		
		//代理的方法invoke子类对象和参数
		if(arg1.getName().equals("makeDecision")){
			System.out.println("预约");
			//子类生成的代理方法.invokeSuper子类对象和参数
			Object result=arg3.invokeSuper(arg0, arg2);
			System.out.println("离开");
			return result;
		}
		return null;
	}
	
	
}
