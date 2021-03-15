package cn.wit.advice;
import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("切点方法对象："+arg1);
		System.out.println("方法名"+arg0.getName());
//		System.out.println("切点方法参数"+arg1[0]);
		System.out.println("方法所在对象"+arg2);
		
		System.out.println("我是前置通知");
	}
	
}
