package cn.wit.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MyAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
//		System.out.println("����ֵ"+arg0);
		System.out.println("�е㷽������"+arg1);
		System.out.println("������"+arg1.getName());
//		System.out.println("�е㷽������"+arg2[0]);
		System.out.println("�������ڶ���"+arg3);
		System.out.println("�ҵĺ���֪ͨ");
	}

}
