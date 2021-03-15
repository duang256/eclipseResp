package cn.wit.pojo;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Secretary implements MethodInterceptor{

	//arg0���������
	//arg1��ʵ����ķ���
	//agr2����
	//arg3�������ɵĴ�����
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		
		//����ķ���invoke�������Ͳ���
		if(arg1.getName().equals("makeDecision")){
			System.out.println("ԤԼ");
			//�������ɵĴ�����.invokeSuper�������Ͳ���
			Object result=arg3.invokeSuper(arg0, arg2);
			System.out.println("�뿪");
			return result;
		}
		return null;
	}
	
	
}
